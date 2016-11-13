package com.help.childin.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.help.childin.R;
import com.help.childin.models.ProductModel;
import com.help.childin.utils.AppConstants;
import com.help.childin.utils.Helper;

public class StoryReaderActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener  {

	//@BindView(R.id.toolbar)
	//Toolbar toolbar;

	@BindView(R.id.img_product)
	ImageView imgProduct;

	@BindView(R.id.txt_product_name)
	TextView txtProductName;

	@BindView(R.id.txt_product_description)
	TextView txtProductDescription;

	@BindView(R.id.txt_product_price)
	TextView txtProductPrice;

	@BindView(R.id.txt_description_msg)
	TextView txtProductMsg;

	private ProductModel productModel;

	private static final int RECOVERY_REQUEST = 1;
	private YouTubePlayerView youTubeView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story_reader);
		ButterKnife.bind(this);
		//toolbar = (Toolbar) findViewById(R.id.toolbar);
		//setSupportActionBar(toolbar);
		readIntentData(getIntent());
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		/*toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});*/

		if (productModel != null) {
			//toolbar.setTitle(productModel.name);
			loadProductData();
		}

	}

	private void loadProductData() {
		txtProductMsg.setTypeface(Helper.getMyBoldTypeFace(StoryReaderActivity.this));

		txtProductName.setTypeface(Helper.getMyTypeFace(StoryReaderActivity.this));
		txtProductDescription.setTypeface(Helper.getMyTypeFace(StoryReaderActivity.this));
		txtProductPrice.setTypeface(Helper.getMyTypeFace(StoryReaderActivity.this));

		imgProduct.setImageResource(productModel.imageId);
		txtProductName.setText(productModel.name);
		txtProductDescription.setText(productModel.description);
		txtProductPrice.setText("Price: "+productModel.price);

	}

	private void readIntentData(Intent intent) {
		productModel = (ProductModel) intent.getSerializableExtra(AppConstants.EXTRA_PRODUCT_MODEL);
	}

	@Override
	public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
		if (!wasRestored) {
			player.cueVideo("fhWaJi1Hsfo"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
		}
	}

	@Override
	public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
		if (errorReason.isUserRecoverableError()) {
			errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
		} else {
			//String error = String.format(getString(R.string.player_error), errorReason.toString());
			Toast.makeText(this, errorReason+"", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == RECOVERY_REQUEST) {
			// Retry initialization if user performed a recovery action
			getYouTubePlayerProvider().initialize(AppConstants.YOUTUBE_API_KEY, this);
		}
	}

	protected YouTubePlayer.Provider getYouTubePlayerProvider() {
		return youTubeView;
	}
}
