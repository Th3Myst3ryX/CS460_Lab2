package com.example.swipeapplicationlab;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private List<VideoItem> videoItems;

    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }


    /**
     *A method to display the videos, their title and description, as well as load the next video
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView textVideoTitle, textVideoDescription;
        VideoView videoView;
        ProgressBar progressBar;

        /**
         *A method that gets the id's of all of the components of the view
         * @param itemView a View that was created for viewing videos
         */
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle = itemView.findViewById(R.id.textViewTitle);
            textVideoDescription = itemView.findViewById(R.id.textViewDescription);
            progressBar = itemView.findViewById(R.id.videoProgressBar);

        }

        /**
         *A method to set the data of the VideoItem object
         * @param videoItem an object of type VideoItem
         */
        void setVideoData(VideoItem videoItem){
            textVideoTitle.setText(videoItem.videoTitle);
            textVideoDescription.setText(videoItem.videoDescription);
            videoView.setVideoPath(videoItem.videoURL);


            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                /**
                 *A listener that prepares the next video for viewing
                 * @param mediaPlayer the MediaPlayer object that will start the videos and get the dimensions of the video
                 */
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progressBar.setVisibility(View.GONE);
                    mediaPlayer.start();

                    float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                    float screenRatio = videoView.getWidth()/(float) videoView.getHeight();

                    float scale = videoRatio/screenRatio;

                    if(scale>1.0){
                        videoView.setScaleX(scale);
                    }else{
                        videoView.setScaleY(1f/scale);

                    }
                }

            });

            /**
             *Starts the video once the prepared listener is completed
             */
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }

    }
}
