package khailnph29864.fpoly.assignment_mob201;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import khailnph29864.fpoly.assignment_mob201.Adapter.NewsAdapter;
import khailnph29864.fpoly.assignment_mob201.OB.News;

public class DownloadTinTuc extends AsyncTask<String, Void, List<News>> {
    Context context;
    ListView lv;
    public DownloadTinTuc(Context context,ListView lv) {

        this.context = context;
        this.lv=lv;
    }

    @Override
    protected List<News> doInBackground(String... strings) {

        TinTucLoader loader = new TinTucLoader();
        List<News> list = new ArrayList<News>();

        // tạo url Connection để tải RSS
        String urlRss = strings[0];

        try {
            URL url = new URL(urlRss);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                // kết nối thành công thì mới lấy luồng dữ liệu
                InputStream inputStream = urlConnection.getInputStream();
                list = loader.getTinTucList(inputStream);

            }

            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    protected void onPostExecute(List<News> tinTucs) {
        super.onPostExecute(tinTucs);

        Log.d("zzzzz", "onPostExecute: số lượng bài viết = " + tinTucs.size());
        for (int i = 0; i < tinTucs.size(); i++) {
            Log.d("zzzzz", "Tiêu đề bài viết:  " + tinTucs.get(i).getTitle());
        }

        // đổ lên listView thì viết code ở đây
        // ListView lv = activity.findViewById(R.id.lv01);
        // làm tiếp với adapter....
        NewsAdapter adapter=new NewsAdapter(context, R.layout.layout_item_news,tinTucs);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(context, "" + tinTucs.get(i).getLink(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, NewsActivity.class);
                intent.putExtra("link", tinTucs.get(i).getLink());
                context.startActivity(intent);

            }
        });
        /*
        quay sang activity viết code thực thi như sau:
         String urlRss = "https://vnexpress.net/rss/cuoi.rss";

        DownloadTinTuc downloadTinTuc = new DownloadTinTuc(MainActivity.this);
        downloadTinTuc.execute(urlRss );
         */


    }
}

