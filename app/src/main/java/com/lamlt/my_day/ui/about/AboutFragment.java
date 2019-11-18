package com.lamlt.my_day.ui.about;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.lamlt.my_day.R;
import com.lamlt.my_day.base.MyBounceInterpolator;

public class AboutFragment extends Fragment {

    private AboutViewModel aboutViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutViewModel =
                ViewModelProviders.of(this).get(AboutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        final ImageView img = root.findViewById(R.id.imgLogo);
        LinearLayout linearLayout = root.findViewById(R.id.linearFeedback);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Thanks for your feedback!")
                            .setMessage("Do you have anything you wish to say to the developer our app ?")
                            .setPositiveButton("Send Email", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Your code
                                Intent intent = new Intent(Intent.ACTION_SENDTO);
                                intent.setType("text/plain");
                                intent.setData(Uri.parse("mailto:"));
                                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"namntph06792@fpt.edu.vn"});
                                intent.putExtra(Intent.EXTRA_SUBJECT, new String[]{getResources().getString(R.string.app_name) + " - " + android.os.Build.BRAND + " " + android.os.Build.MODEL});
                                //intent.putExtra(Intent.EXTRA_TEXT, message);
                                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        });
                AlertDialog alert =builder.create();
                alert.show();
            }
        });
        animateImageView(img);
        return root;
    }

    private void animateImageView(final View view) {
        // Load the animation
        Animation myAnim = AnimationUtils.loadAnimation(view.getContext(), R.anim.bounce);
        //val animationDuration = 0.2 * 1000
        //myAnim.duration = animationDuration.toLong()

        // Use custom animation interpolator to achieve the bounce effect
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2,20.0);

        myAnim.setInterpolator(interpolator);

        // Animate the button
        view.startAnimation(myAnim);

        // Run button animation again after it finished
        myAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animateImageView(view);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}