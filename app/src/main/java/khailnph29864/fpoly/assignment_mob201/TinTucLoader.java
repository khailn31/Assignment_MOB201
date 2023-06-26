package khailnph29864.fpoly.assignment_mob201;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import khailnph29864.fpoly.assignment_mob201.OB.News;

public class TinTucLoader {
    List<News> tinTucList = new ArrayList<News>();

    News news;
    String textContent;

    public List<News> getTinTucList(InputStream inputStream) {
        // nội dung tự viết , tham khảo ví dụ product
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            // truyền nguồn dữ liệu
            parser.setInput(inputStream, null);
            // xác định event type
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                // viết code xử lý ở đây
                String tagName = parser.getName();
                Log.d("zzzzz", "Tag name =  " + tagName +
                        ", Độ sâu của thẻ = " + parser.getDepth() + ", event = " + eventType);


                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        // bắt đầu vào 1 thẻ
                        if (tagName.equalsIgnoreCase("item")) {
                            news = new News();
                            tinTucList.add(news);
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textContent = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if(news != null){
                            //
                            if (tagName.equalsIgnoreCase("title")){
                                news.setTitle( textContent );
                            }

                            if (tagName.equalsIgnoreCase("link"))
                            {
                                news.setLink( textContent );
                            }
                            if (tagName.equalsIgnoreCase("description")){
                                Pattern pattern = Pattern.compile("src=\"(.*?)\"");
                                Matcher matcher = pattern.matcher(textContent);  // biến description thay thế bằng thuộc tính của đối tượng DTO
                                String url_image = "";
                                if (matcher.find())
                                {
                                    url_image = matcher.group(1);
                                    Log.d("zzzzzzz", "URL ảnh: " + url_image);
                                    news.setImg(url_image);
                                }

                            }

                        }


                        break;
                    default:
                        Log.d("zzzz", "eventType khác: " + eventType + ", tag = " + tagName);
                        break;
                }


                // viết lệnh chuyển event type để vòng lặp không bị treo
                // để ở cuối cùng của lệnh while
                eventType = parser.next();
            }
            inputStream.close();

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tinTucList;
    }
}
