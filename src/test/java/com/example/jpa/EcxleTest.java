package com.example.jpa;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.Collator;
import java.util.*;

public class EcxleTest {
    private Map<String,String> InitMap(){
        Map<String, String> cityMapList = new HashMap<>();
        cityMapList.put("辽阳","123.17424-41.27031");
        cityMapList.put("张家界","110.55042-29.34589");
        cityMapList.put("宜春","114.42773-27.79817");
        cityMapList.put("河池","108.03719-24.68983");
        cityMapList.put("伊春","128.6690-47.7258");
        cityMapList.put("山南","91.7614-29.2248");
        cityMapList.put("那曲","92.0514-31.4761");
        cityMapList.put("林芝","94.3612-94.3612");
        cityMapList.put("黄山","118.1412-30.2730");
        cityMapList.put("海东","102.4017-36.4821");
        cityMapList.put("广安","106.6419-30.4740");
        cityMapList.put("昌都","97.1804-31.1383");
        cityMapList.put("博尔塔拉蒙古自治州","82.0667-44.9060");
        cityMapList.put("西安","108.9342-34.2305");
        cityMapList.put("东营","118.5822-37.4488");
        cityMapList.put("中山","113.3926-22.5160");
        cityMapList.put("荆州","112.1902-30.3527");
        cityMapList.put("淮安","119.0213-33.5975");
        cityMapList.put("儋州","109.5807-19.5210");
        cityMapList.put("香港","114.1655-22.2753");
        cityMapList.put("襄阳","112.1355-32.0449");
        cityMapList.put("毕节","105.3051-27.2985");
        cityMapList.put("大同","113.1401-40.2559");
        cityMapList.put("白银","104.1724-36.5345");
        cityMapList.put("澳门","113.5491-22.1988");
        cityMapList.put("铜仁","109.1810-27.6907");
        cityMapList.put("哈密","93.5147-42.8270");
        cityMapList.put("资阳","104.6522-30.1176");
        cityMapList.put("杨凌","108.08455-34.27221");
        cityMapList.put("嘉义","120.472462-23.485079");
        cityMapList.put("基隆","121.741526-25.122105");

        return cityMapList;
    }

    @Test
    public void test1() throws Exception {
//        String path="C:\\Users\\Junmoxiao\\Desktop\\frequently" +
//                "\\论文基础数据\\论文基础数据 2011.xlsx";
        File file = new File("C:\\Users\\Junmoxiao\\Desktop" +
                "\\frequently\\论文基础数据\\result\\2011Discontent" +
                ".xlsx");
//        Entity entity = ExcelReaderUtil.readExcel(path);
        String a = "阿坝藏族羌族自治州-阿克苏地区-阿拉尔-阿拉善盟-阿勒泰地区-阿里地区-鞍山-安康-安庆-安顺-安阳-澳门-巴彦淖尔-巴音郭楞蒙古自治州-巴中-白城-白沙黎族自治县-白山-白银-百色-蚌埠-包头-保定-保山-保亭黎族苗族自治县-宝鸡-北海-北京-北屯-本溪-毕节-滨州-博尔塔拉蒙古自治州-沧州-昌都-昌吉回族自治州-昌江黎族自治县-常德-常州-长春-长沙-长治-朝阳-潮州-巢湖-郴州-成都-澄迈-承德-池州-赤峰-崇左-滁州-楚雄彝族自治州-达州-大理白族自治州-大连-大庆-大同-大兴安岭地区-丹东-德宏傣族景颇族自治州-德阳-德州-迪庆藏族自治州-定安-定西-东方-东营-东莞-鄂尔多斯-鄂州-恩施土家族苗族自治州-防城港-佛山-福州-抚顺-抚州-阜新-阜阳-甘南藏族自治州-甘孜藏族自治州-赣州-固原-广安-广元-广州-桂林-贵港-贵阳-果洛藏族自治州-哈尔滨-哈密-海北藏族自治州-海东-海口-海南藏族自治州-海西蒙古族藏族自治州-邯郸-汉中-杭州-菏泽-和田地区-合肥-河池-河源-鹤壁-鹤岗-贺州-黑河-衡水-衡阳-红河哈尼族彝族自治州-呼和浩特-呼伦贝尔-葫芦岛-湖州-怀化-淮安-淮北-淮南-黄冈-黄南藏族自治州-黄山-黄石-惠州-基隆-鸡西-吉安-吉林-济南-济宁-济源-嘉兴-嘉义-嘉峪关-佳木斯-江门-焦作-揭阳-金昌-金华-锦州-晋城-晋中-荆门-荆州-景德镇-九江-酒泉-喀什地区-开封-克拉玛依-克孜勒苏柯尔克孜自治州-昆明-昆山-拉萨-莱芜-来宾-兰州-廊坊-乐东黎族自治县-乐山-丽江-丽水-连云港-凉山彝族自治州-聊城-辽阳-辽源-林芝-临安-临沧-临汾-临高-临夏回族自治州-临沂-陵水黎族自治县-柳州-六安-六盘水-龙岩-陇南-娄底-吕梁-洛阳-马鞍山-茂名-梅州-眉山-绵阳-牡丹江-那曲-南昌-南充-南京-南宁-南平-南通-南阳-内江-宁波-宁德-怒江傈僳族自治州-攀枝花-盘锦-盘州-萍乡-平顶山-平凉-莆田-普洱-七台河-齐齐哈尔-黔东南苗族侗族自治州-黔南布依族苗族自治州-黔西南布依族苗族自治州-潜江-钦州-秦皇岛-青岛-青海-清远-庆阳-琼海-琼中黎族苗族自治县-曲靖-泉州-日喀则-日照-如皋-三门峡-三明-三沙-三亚-山南-汕头-汕尾-商洛-商丘-上海-上饶-韶关-邵阳-绍兴-深圳-神农架林区-沈阳-十堰-石河子-石家庄-石嘴山-双鸭山-朔州-思茅-四平-松原-苏州-宿迁-宿州-随州-绥化-遂宁-塔城地区-台湾-台州-泰安-泰州-太原-唐山-天津-天门-天水-铁岭-通化-通辽-铜川-铜陵-铜仁-图木舒克-吐鲁番-屯昌-万宁-威海-潍坊-渭南-温州-文昌-文山壮族苗族自治州-乌海-乌兰察布-乌鲁木齐-无锡-芜湖-梧州-吴忠-武汉-武威-五家渠-五指山-西安-西宁-西双版纳傣族自治州-锡林郭勒盟-厦门-仙桃-咸宁-咸阳-香港-襄阳-湘潭-湘西土家族苗族自治州-孝感-孝义-新疆-新乡-新余-忻州-信阳-兴安盟-邢台-徐州-许昌-宣城-雅安-烟台-盐城-延安-延边朝鲜族自治州-杨凌-扬州-阳江-阳泉-伊春-伊犁哈萨克自治州-伊宁-宜宾-宜昌-宜城-宜春-义乌-益阳-银川-鹰潭-营口-永州-榆林-玉林-玉树藏族自治州-玉溪-岳阳-云浮-运城-枣庄-湛江-漳州-张家界-张家口-张掖-昭通-肇庆-镇江-郑州-中山-中卫-重庆-舟山-周口-珠海-株洲-驻马店-资阳-淄博-自贡-遵义-儋州-亳州-衢州-泸州-涿州-漯河-濮阳";
        String strs[] =a.split("-");
        List<String> city = Arrays.asList(strs);
//        Collections.sort(city, (String o1,String o2)-> Collator.getInstance(Locale.CHINESE).compare(o1,o2));
        System.out.println(city.toString());
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet();
        //创建表中的第一行  索引为0
        XSSFRow row = sheet.createRow(0);
        //创建单元格
        XSSFCell cellTitle = null;
        //在第一行插入单元格设置值
        for(int i=1;i <= city.size();i++){
            cellTitle = row.createCell(i);
            cellTitle.setCellValue(city.get(i-1));
        }
        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
        for(int i = 1;i <= city.size(); i++){
            XSSFRow oneRow = sheet.createRow(i);
            XSSFCell cellRow = oneRow.createCell(0);
            cellRow.setCellValue(city.get(i-1));
        }
        Set<String> sets = new HashSet<>(city);
        List<String> lists = ExcelReaderUtil.MapMatch(sets);
        Map<String,String> mapresult = InitMap();
        for (String OneCity:lists) {
            String [] key = OneCity.split("-");
            int one = city.indexOf(key[0]);
            int two = city.indexOf(key[1]);
            XSSFRow nextRow = sheet.getRow(one+1);
            if(nextRow == null){
                nextRow = sheet.createRow(one+1);
            }
            Object[] twoAddr = new Object[0];
            Object[] oneAddr = new Object[0];
            String ext = "基隆嘉义河池杨凌伊春山南那曲林芝黄山海东广安昌都博尔塔拉蒙古自治州西安东营中山荆州淮安儋州香港襄阳毕节大同白银澳门铜仁哈密资阳";
            if(ext.contains(key[1]) && ext.contains(key[0]) || mapresult.get(key[0]) != null && mapresult.get(key[1]) != null){
                System.out.println(key[0]+key[1]);
                twoAddr = mapresult.get(key[1]).split("-");
                oneAddr = mapresult.get(key[0]).split("-");
            } else if(ext.contains(key[1]) || mapresult.get(key[0]) == null && mapresult.get(key[1]) != null){
                System.out.println(key[0]+key[1]);
                oneAddr = getLatAndLngByBaidu.getCoordinate(key[0]);
                mapresult.put(key[0],oneAddr[0]+"-"+oneAddr[1]);
                twoAddr = mapresult.get(key[1]).split("-");
            }else if( ext.contains(key[0]) || mapresult.get(key[1]) == null && mapresult.get(key[0]) != null){
                System.out.println(key[0]+key[1]);
                twoAddr = getLatAndLngByBaidu.getCoordinate(key[1]);
                mapresult.put(key[1],twoAddr[0]+"-"+twoAddr[1]);
                oneAddr = mapresult.get(key[0]).split("-");
            }
            else {
                System.out.println(key[0]+key[1]);
                oneAddr = getLatAndLngByBaidu.getCoordinate(key[0]);
                mapresult.put(key[0],oneAddr[0]+"-"+oneAddr[1]);
                twoAddr = getLatAndLngByBaidu.getCoordinate(key[1]);
                mapresult.put(key[1],twoAddr[0]+"-"+twoAddr[1]);

            }

//            System.out.println(key[0]+ oneAddr.toString());
//            System.out.println(key[0]+ twoAddr.toString());
            double distance =
                    LocationUtils.getDistance(Double.valueOf(oneAddr[1].toString()),
                            Double.valueOf(oneAddr[0].toString()),
                            Double.valueOf(twoAddr[1].toString()),
                            Double.valueOf(twoAddr[0].toString()));
            System.out.println(key[0]+"-"+key[1]+"距离" + distance / 1000 + "公里");
            //创建下一行的单元格对象 索引是一行中的第几个单元格
            XSSFCell cellContent = nextRow.createCell(two+1);
            cellContent.setCellValue(distance / 1000);
        }
        OutputStream stream= new FileOutputStream(file);
        //将Excel文件写入创建的file当中
        workbook.write(stream);
        //关闭流
        stream.close();


    }
    @Test
    public void test() throws IOException {
        File excel = new File("C:\\Users\\linux\\Desktop\\1.xlsx");
        String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！
        Workbook wb;
        //根据文件后缀（xls/xlsx）进行判断
        if ( "xls".equals(split[1]) || "csv".equals(split[1])){
            FileInputStream fiStream = new FileInputStream(excel);   //文件流对象
            wb = new HSSFWorkbook(fiStream);
        }else{
            wb = new XSSFWorkbook(new FileInputStream(excel));
        }
        //开始解析
        Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

        int firstRowIndex = sheet.getFirstRowNum();   //第一行是列名，所以不读
        int lastRowIndex = sheet.getLastRowNum();
        String start = "";
        Set<String> sets = new HashSet<>();
        for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
            Row row = sheet.getRow(rIndex);
            if (row != null) {
                String one = row.getCell(0).toString();
                String two = row.getCell(3).toString();
                if(start.equals(one)){
                    sets.add(two);
                    if(lastRowIndex == rIndex){
                        Map<String ,Integer> result = MapMatch(sets);
                        System.out.println(result.toString());
                        //记录次数
                    }
                }else {
                    start = one;
                    if(sets.size() == 0){
                        sets.add(two);
                    }else if(sets.size() == 1){
                        sets.clear();
                    } else {
                        Map<String ,Integer> result = MapMatch(sets);
                        System.out.println(result.toString());
                        //记录次数
                        sets.clear();
                    }

                }
            }

        }
    }

    @Test
    public void t1est() throws IOException {
        File file = new File("C:\\Users\\Junmoxiao\\Desktop\\frequently\\poi_test1.xlsx");
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet();
        Map<String ,Integer> map= new HashMap<>();
        map.put("南京-北京",505);
        map.put("北京-南京",505);
        map.put("北京-西安",488);
        map.put("西安-北京",488);
        //写入具体数据
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); //转换为list
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<String> list1 = new ArrayList<>();
        list1.add("南京");
        list1.add("北京");
        list1.add("西安");
        for (Map.Entry<String, Integer> mapping : list){
            String [] key = mapping.getKey().split("-");
            int one = list1.indexOf(key[0]);
            int two = list1.indexOf(key[1]);

            //创建表中的第一行  索引为0
            XSSFRow row = sheet.getRow(one);
            if(row == null){
                row = sheet.createRow(one);
            }
            //创建单元格
            XSSFCell cell = row.createCell(two);
            cell.setCellValue("key:"+mapping.getValue());
        }
        OutputStream stream= new FileOutputStream(file);
        //将Excel文件写入创建的file当中
        workbook.write(stream);
        //关闭流
        stream.close();

    }

    @Test
    public void show() throws Exception {
        String path="C:\\Users\\Junmoxiao\\Desktop\\frequently" +
                "\\论文基础数据\\论文基础数据 2011.xlsx";
        File file = new File("C:\\Users\\Junmoxiao\\Desktop" +
                "\\frequently\\论文基础数据\\result\\2011Discontent" +
                ".xlsx");
        Entity entity = ExcelReaderUtil.readExcel(path);
        Map<String ,Integer> map = entity.getStringIntegerMap();
        System.out.println("有联系数目:"+map.size());
        //写入行列
        //把set转为list1
        List<String> city = new ArrayList<>(entity.getExcelString());
        //实现排序方法
        Collections.sort(city,
                (String o1,String o2)-> Collator.getInstance(Locale.CHINESE).compare(o1,o2));
        System.out.println(city.toString());
//        GetLatAndLngByBaidu getLatAndLngByBaidu1 =
//                new GetLatAndLngByBaidu();
//
//        for(String s :city){
//            if(
//                    "伊春，山南、那曲林芝黄山海东广安昌都博尔塔拉蒙古自治州西安东营中山荆州淮安儋州香港襄阳毕节大同白银澳门铜仁哈密资阳".contains(s) ){
//                continue;
//            }
//            System.out.println(s);
//            Object o[] =
//                    getLatAndLngByBaidu1.getCoordinate(s);
//
//        }


        //写行列
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet();
        //创建表中的第一行  索引为0
        XSSFRow row = sheet.createRow(0);
        //创建单元格
        XSSFCell cellTitle = null;
        //在第一行插入单元格设置值
        for(int i=1;i <= city.size();i++){
            cellTitle = row.createCell(i);
            cellTitle.setCellValue(city.get(i-1));
        }
        for(int i = 1;i <= city.size(); i++){
            XSSFRow oneRow = sheet.createRow(i);
            XSSFCell cellRow = oneRow.createCell(0);
            cellRow.setCellValue(city.get(i-1));
        }

        //写入具体数据
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); //转换为list
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
//        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
        for (Map.Entry<String, Integer> mapping : list){
//            if(mapping.getValue()<= 5){
////                System.out.println(mapping.getKey()+": "+mapping.getValue());
//                break;
//            }
            System.out.println(mapping.getKey()+": "+mapping.getValue());
            //获取行列
            String [] key = mapping.getKey().split("-");
            int one = city.indexOf(key[0]);
            int two = city.indexOf(key[1]);
            XSSFRow nextRow = sheet.getRow(one+1);
            if(nextRow == null){
                nextRow = sheet.createRow(one+1);
            }
            if("伊春山南那曲林芝黄山海东广安昌都博尔塔拉蒙古自治州西安东营中山荆州淮安儋州香港襄阳毕节大同白银澳门铜仁哈密资阳".contains(key[1]) || "伊春，山南、那曲林芝黄山海东广安昌都博尔塔拉蒙古自治州西安东营中山荆州淮安儋州香港襄阳毕节大同白银澳门铜仁哈密资阳".contains(key[0])){
                continue;
            }

            Object[] twoAddr = new Object[0];
            Object[] oneAddr = new Object[0];
            try {
                oneAddr =
                        getLatAndLngByBaidu.getCoordinate(key[0]);
                twoAddr =
                        getLatAndLngByBaidu.getCoordinate(key[1]);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(mapping.getKey());
            }

//            System.out.println(key[0]+ oneAddr.toString());
//            System.out.println(key[0]+ twoAddr.toString());
            double distance =
                    LocationUtils.getDistance(Double.valueOf(oneAddr[1].toString()),
                            Double.valueOf(oneAddr[0].toString()),
                            Double.valueOf(twoAddr[1].toString()),
                            Double.valueOf(twoAddr[0].toString()));
//            System.out.println("距离" + distance / 1000 + "公里");
            //创建下一行的单元格对象 索引是一行中的第几个单元格
            XSSFCell cellContent = nextRow.createCell(two+1);
            cellContent.setCellValue(distance / 1000);
        }
        OutputStream stream= new FileOutputStream(file);
        //将Excel文件写入创建的file当中
        workbook.write(stream);
        //关闭流
        stream.close();
    }

    /**
     * 获取经纬度
     *
     * @author jueyue 返回格式：Map<String,Object> map map.put("status",
     * reader.nextString());//状态 map.put("result", list);//查询结果
     * list<map<String,String>>
     * 密钥:f247cdb592eb43ebac6ccd27f796e2d2
     */
    public class GetLatAndLngByBaidu {

        /**
         * @param addr
         * 查询的地址
         * @return
         * @throws IOException
         */
        public Object[] getCoordinate(String addr) throws ArrayIndexOutOfBoundsException {
            String lng = null;//经度
            String lat = null;//纬度
            String address = null;
            try {
                address = java.net.URLEncoder.encode(addr, "UTF-8");
            }catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            String key = "f247cdb592eb43ebac6ccd27f796e2d2";
            String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s", address, key);
            URL myURL = null;
            URLConnection httpsConn = null;
            try {
                myURL = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            InputStreamReader insr = null;
            BufferedReader br = null;
            try {
                httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
                if (httpsConn != null) {
                    insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");
                    br = new BufferedReader(insr);
                    String data = null;
                    int count = 1;
                    while((data= br.readLine())!=null){
                        if(count==5){
                            lng = (String)data.subSequence(data.indexOf(":")+1, data.indexOf(","));//经度
                            count++;
                        }else if(count==6){
                            lat = data.substring(data.indexOf(":")+1);//纬度
                            count++;
                        }else{
                            count++;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(insr!=null){
                    try {
                        insr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(br!=null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return new Object[]{lng,lat};
        }
    }

    @Test
    public  void getXy() throws IOException {
        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
        Object[] o = new Object[0];
            o = getLatAndLngByBaidu.getCoordinate("北京");
            Object[] o1 = getLatAndLngByBaidu.getCoordinate("黔东南苗族侗族自治州");

        System.out.println("北京");
        System.out.println(o[1]);//经度
        System.out.println(o[0]);//纬度
        System.out.println("上海");
        System.out.println(o1[1]);//经度
        System.out.println(o1[0]);//纬度
        double distance =
                LocationUtils.getDistance(Double.valueOf(o[1].toString()),
                        Double.valueOf(o[0].toString()),
                        Double.valueOf(o1[1].toString()),
                        Double.valueOf(o1[0].toString()));
        System.out.println("距离" + distance / 1000 + "公里");
    }
    public static Map<String, Integer> MapMatch(Set<String> sets) {
        Map<String,Integer> stringStringMap = new HashMap<>();
        Object [] arrays = sets.toArray();
        int sum = sets.size();
        for(int i =0; i < sum; i++){
            for(int j = i+1;j < sum; j++){
                stringStringMap.put(arrays[i].toString()+"-"+arrays[j].toString()
                        ,1);
            }
        }
        return stringStringMap;
    }

    @Test
    public void s(){

    }

}
