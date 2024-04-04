package com.example.fragments;

import android.annotation.SuppressLint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newone.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fragment3 extends Fragment {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView capturedImageView;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        capturedImageView = view.findViewById(R.id.capturedImageView);
        ImageView cameraButton = view.findViewById(R.id.cameraButton);
        ImageView downloadButton = view.findViewById(R.id.downloadButton);
        ImageView deleteButton = view.findViewById(R.id.deleteButton);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (capturedImageView.getDrawable() != null) {
                    // Get the Bitmap from the ImageView
                    Bitmap bitmap = ((BitmapDrawable) capturedImageView.getDrawable()).getBitmap();

                    // Save the Bitmap to a file (for simplicity, saving to external storage)
                    String fileName = "captured_photo.png";
                    File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    File file = new File(directory, fileName);

                    try {
                        // Create a FileOutputStream to write the Bitmap to the file
                        FileOutputStream fos = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                        fos.close();

                        // Display a toast message indicating the download
                        Toast.makeText(getActivity(), "Photo downloaded! Path: " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        // Handle the exception, for example, display an error toast message
                        Toast.makeText(getActivity(), "Failed to download photo!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // No photo to download, display a message or handle accordingly
                    Toast.makeText(getActivity(), "No photo to download!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the captured image view to delete the photo
                capturedImageView.setImageDrawable(null);
            }
        });

        return view;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            capturedImageView.setImageBitmap(imageBitmap);
        }
    }
}