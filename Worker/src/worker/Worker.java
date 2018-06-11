/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author trieunx
 */
public class Worker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Document doc = Jsoup.connect("https://xosominhngoc.net.vn/ajax/?view=ketqua&id=mien-bac&date=04-06-2018").get();
        Elements kqsx = doc.select("div.box_kqxs");
        for (Element el : kqsx) {
            String id = el.attr("id");

            System.out.println("===============:" + id);
            //boc ket qua tung ngay
            Elements kq = el.select("table tr");
            int index = 0;
            for (Element tr : kq) {
                //phat hanh
                if (index == 0) {
                    Element phathanh = tr.selectFirst("td.tentinh a");
                    //System.out.println("Tỉnh:"+ phathanh.attr("href").substring(1));
                }else
                {
                   // Element giai = tr.selectFirst("td[class=giai^]");
                    //System.out.println(giai.toString());
                
                }
                index++;
                System.out.println(tr.toString());
            }
        }
    }
    
}
