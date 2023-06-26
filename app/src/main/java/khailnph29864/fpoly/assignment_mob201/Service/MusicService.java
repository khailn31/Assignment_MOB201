package khailnph29864.fpoly.assignment_mob201.Service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import khailnph29864.fpoly.assignment_mob201.OB.Music;
import khailnph29864.fpoly.assignment_mob201.R;

public class MusicService extends Service {
    public final static String ACTION_PAUSE = "playmusic.ACTION_PAUSE";
    public final static String ACTION_RESUME = "playmusic.ACTION_RESUME";
    MediaPlayer musicPlayer;



    @Override
    public void onCreate() {
        super.onCreate();
//        addSong();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        register_pause();
        register_resume();
        int song= intent.getIntExtra("file",0);
        musicPlayer=MediaPlayer.create(this,song);
        musicPlayer.start();
        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        musicPlayer.stop();
        super.onDestroy();
    }

    private BroadcastReceiver pause = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String act = intent.getAction();
            // lấy action dối chiếu thao tác
            Log.d("mmm", "onReceive: " + act);

            switch (act) {
                case MusicService.ACTION_PAUSE:
                    musicPlayer.pause();
                    break;
                case MusicService.ACTION_RESUME:
                    musicPlayer.start();
                    break;
                default:
                    //Không làm gì cả

            }
        }
    };

    private void register_pause() {
        IntentFilter intentFilter = new IntentFilter(MusicService.ACTION_PAUSE);
        this.registerReceiver(pause, intentFilter);
    }

    private void register_resume() {
        IntentFilter intentFilter = new IntentFilter(MusicService.ACTION_RESUME);
        this.registerReceiver(pause, intentFilter);
    }


}
