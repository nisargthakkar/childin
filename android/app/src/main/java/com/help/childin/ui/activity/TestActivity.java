package com.help.childin.ui.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.hardware.camera2.CaptureFailure;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.help.childin.R;
import com.help.childin.models.ProductModel;
import com.help.childin.ui.fragment.ContactFragment;
import com.help.childin.utils.AppConstants;
import com.help.childin.utils.Helper;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity implements OnInitializedListener{

    private static final int RECOVERY_REQUEST = 1;
    //private YouTubePlayerView youTubeView;
    private MyPlayerStateChangeListener playerStateChangeListener;
    private MyPlaybackEventListener playbackEventListener;
    private YouTubePlayer player;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    //@BindView(R.id.img_product)
    //ImageView imgProduct;

    @BindView(R.id.txt_product_name)
    TextView txtProductName;

    @BindView(R.id.txt_product_description)
    TextView txtProductDescription;

    @BindView(R.id.txt_product_price)
    TextView txtProductPrice;

    @BindView(R.id.txt_description_msg)
    TextView txtProductMsg;

    @BindView(R.id.btn_shop_now)
    Button btnShopNow;

    private ProductModel productModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        readIntentData(getIntent());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});

        playerStateChangeListener = new MyPlayerStateChangeListener();
        playbackEventListener = new MyPlaybackEventListener();

        YouTubePlayerSupportFragment frag =
                (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);
        frag.initialize(AppConstants.YOUTUBE_API_KEY, this);

        if (productModel != null) {
            //toolbar.setTitle(productModel.name);
            loadProductData();
        }

        btnShopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDialogFragment();
            }
        });

    }

    private void callDialogFragment() {
        FragmentManager fm = getFragmentManager();
        ContactFragment dialogFragment = new ContactFragment ();
        dialogFragment.show(fm, "Sample Fragment");
    }

    private void loadProductData() {
        txtProductMsg.setTypeface(Helper.getMyBoldTypeFace(TestActivity.this));

        txtProductName.setTypeface(Helper.getMyTypeFace(TestActivity.this));
        txtProductDescription.setTypeface(Helper.getMyTypeFace(TestActivity.this));
        txtProductPrice.setTypeface(Helper.getMyTypeFace(TestActivity.this));

        //imgProduct.setImageResource(productModel.imageId);
        txtProductName.setText(productModel.name);
        txtProductDescription.setText(productModel.description);
        txtProductPrice.setText("Price: "+productModel.price);

        btnShopNow.setTypeface(Helper.getMyBoldTypeFace(TestActivity.this));

    }

    private void readIntentData(Intent intent) {
        productModel = (ProductModel) intent.getSerializableExtra(AppConstants.EXTRA_PRODUCT_MODEL);
    }


    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        this.player = player;
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        if (!wasRestored & productModel != null && productModel.videourl != null) {
            player.cueVideo(productModel.videourl); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            //String error = String.format(getString(R.string.player_error), errorReason.toString());
            //Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            //getYouTubePlayerProvider().initialize(AppConstants.YOUTUBE_API_KEY, this);
        }
    }

    private void showMessage(String message) {
       // Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private final class MyPlaybackEventListener implements YouTubePlayer.PlaybackEventListener {

        @Override
        public void onPlaying() {
            // Called when playback starts, either due to user action or call to play().
            showMessage("Playing");
        }

        @Override
        public void onPaused() {
            // Called when playback is paused, either due to user action or call to pause().
            showMessage("Paused");
        }

        @Override
        public void onStopped() {
            // Called when playback stops for a reason other than being paused.
            showMessage("Stopped");
        }

        @Override
        public void onBuffering(boolean b) {
            // Called when buffering starts or ends.
        }

        @Override
        public void onSeekTo(int i) {
            // Called when a jump in playback position occurs, either
            // due to user scrubbing or call to seekRelativeMillis() or seekToMillis()
        }
    }

    private final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {

        @Override
        public void onLoading() {
            // Called when the player is loading a video
            // At this point, it's not ready to accept commands affecting playback such as play() or pause()
        }

        @Override
        public void onLoaded(String s) {
            // Called when a video is done loading.
            // Playback methods such as play(), pause() or seekToMillis(int) may be called after this callback.
        }

        @Override
        public void onAdStarted() {
            // Called when playback of an advertisement starts.
        }

        @Override
        public void onVideoStarted() {
            // Called when playback of the video starts.
        }

        @Override
        public void onVideoEnded() {
            // Called when the video reaches its end.
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            // Called when an error occurs.
        }
    }

}
