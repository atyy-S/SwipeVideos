package com.example.swipevideo;

import android.icu.number.Scale;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class videoAdapter extends RecyclerView.Adapter<videoAdapter.videoViewHolder> { //handle video streaming
    // creating consturctor
    public videoAdapter(List<videoItem> videoItems) { //video adapter
        this.videoItems = videoItems;
    }
    private List<videoItem> videoItems;

    @NonNull
    @Override
    public videoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //to hold the video
        return new videoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video, parent, false)
        );
    }

    /**
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull videoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }


    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    //RecyclerView.ViewHolder for swipe the video

    /**defines a static inner class named videoViewHolder that extends RecyclerView.ViewHolder
     *It's used to display video items in a RecyclerView*/
    static class videoViewHolder extends RecyclerView.ViewHolder {
        TextView textVideoTitle1, textVideoDescription1;
        VideoView videoView;
        ProgressBar progressBar;

        public videoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle1=itemView.findViewById(R.id.textVideoTitle); //from the xml
            textVideoDescription1=itemView.findViewById(R.id.textVideoDescription); //this fuction
            progressBar=itemView.findViewById(R.id.videoProgressBar);
        }
        void setVideoData(videoItem videoItem){ //when play the video
            textVideoTitle1.setText(videoItem.videoTitle);
            textVideoDescription1.setText(videoItem.videoDescription);
            videoView.setVideoPath(videoItem.videoURL);

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // before swipe the next video, it needs to be prepared first.
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility((View.GONE));
                    mp.start();
                    //make the ration of the video consistent
                    float videoRatio =mp.getVideoWidth()/(float) mp.getVideoHeight();
                    float screenRatio= videoView.getWidth()/(float) videoView.getHeight();
                    float scale =videoRatio/screenRatio;
                    if (scale >=1f){
                        videoView.setScaleX(scale);
                    }
                    else{
                        videoView.setScaleY(1f/scale);
                    }
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start(); //start play the video

                }
            });


        }

    }
}
