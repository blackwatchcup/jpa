package com.example.jpa;

import java.util.*;

/**
 * @author y
 * @create 2018-01-19 0:13
 * @desc
 **/
public class ExcelReaderUtil {
    //excel2003扩展名
    public static final String EXCEL03_EXTENSION = ".xls";
    //excel2007扩展名
    public static final String EXCEL07_EXTENSION = ".xlsx";
    public static Set<String> sets = new HashSet<>();
    public static Set<String> excelSets = new HashSet<>();
    public static String start = "";
    public static final String city = "阿尔巴尼亚\n" +
            "阿尔及利亚\n" +
            "阿富汗\n" +
            "阿根廷\n" +
            "阿拉伯联合酋长国\n" +
            "阿联酋\n" +
            "阿曼\n" +
            "阿塞拜疆\n" +
            "埃及\n" +
            "埃塞俄比亚\n" +
            "爱尔兰\n" +
            "爱沙尼亚\n" +
            "安哥拉\n" +
            "奥地利\n" +
            "澳大利亚\n" +
            "巴基斯坦\n" +
            "巴林\n" +
            "巴西\n" +
            "白俄罗斯\n" +
            "保加利亚\n" +
            "贝宁\n" +
            "比利时\n" +
            "冰岛\n" +
            "波多黎各\n" +
            "波黑\n" +
            "波兰\n" +
            "博茨瓦纳\n" +
            "博尔塔拉\n" +
            "朝鲜\n" +
            "丹麦\n" +
            "德国\n" +
            "东京\n" +
            "多哥\n" +
            "俄罗斯\n" +
            "厄瓜多尔\n" +
            "法国\n" +
            "法属玻利尼西亚\n" +
            "菲律宾\n" +
            "斐济\n" +
            "芬兰\n" +
            "刚果\n" +
            "哥伦比亚\n" +
            "哥斯达黎加\n" +
            "格鲁吉亚\n" +
            "古巴\n" +
            "哈萨克斯坦\n" +
            "海地\n" +
            "韩国\n" +
            "荷兰\n" +
            "吉尔吉斯斯坦\n" +
            "几内亚\n" +
            "加拿大\n" +
            "加纳\n" +
            "柬埔寨\n" +
            "捷克\n" +
            "津巴布韦\n" +
            "喀麦隆\n" +
            "卡塔尔\n" +
            "科特迪瓦\n" +
            "科威特\n" +
            "克罗地亚\n" +
            "肯尼亚\n" +
            "拉托维亚\n" +
            "拉脱维亚\n" +
            "黎巴嫩\n" +
            "立陶宛\n" +
            "利比里亚\n" +
            "利比亚\n" +
            "卢森堡\n" +
            "罗马尼亚\n" +
            "马达加斯加\n" +
            "马耳他\n" +
            "马拉维\n" +
            "马来西亚\n" +
            "马里\n" +
            "马其顿\n" +
            "毛里求斯\n" +
            "美国\n" +
            "蒙古\n" +
            "孟加拉\n" +
            "孟加拉国\n" +
            "秘鲁\n" +
            "缅甸\n" +
            "摩尔多瓦\n" +
            "摩洛哥\n" +
            "莫桑比克\n" +
            "墨西哥\n" +
            "纳米比亚\n" +
            "南非\n" +
            "尼泊尔\n" +
            "尼加拉瓜\n" +
            "尼日尔\n" +
            "尼日利亚\n" +
            "挪威\n" +
            "葡萄牙\n" +
            "日本\n" +
            "瑞典\n" +
            "瑞士\n" +
            "塞尔维亚\n" +
            "塞拉利昂\n" +
            "塞内加尔\n" +
            "塞浦路斯\n" +
            "塞舌尔\n" +
            "沙特阿拉伯\n" +
            "斯里兰卡\n" +
            "斯洛伐克\n" +
            "斯洛文尼亚\n" +
            "苏丹\n" +
            "苏联\n" +
            "泰国\n" +
            "坦桑尼亚\n" +
            "特立尼达和多巴哥\n" +
            "突尼斯\n" +
            "土耳其\n" +
            "土库曼斯坦\n" +
            "委内瑞拉\n" +
            "文莱\n" +
            "乌干达\n" +
            "乌克兰\n" +
            "乌拉圭\n" +
            "乌兹别克斯坦\n" +
            "西班牙\n" +
            "希腊\n" +
            "新加坡\n" +
            "新西兰\n" +
            "匈牙利\n" +
            "叙利亚\n" +
            "亚美尼亚\n" +
            "也门\n" +
            "伊拉克\n" +
            "伊朗\n" +
            "以色列\n" +
            "意大利\n" +
            "印度\n" +
            "印度尼西亚\n" +
            "英国\n" +
            "约旦\n" +
            "越南\n" +
            "赞比亚\n" +
            "乍得\n" +
            "智利";

    /**
     * 每获取一条记录，即打印
     * 在flume里每获取一条记录即发送，而不必缓存起来，可以大大减少内存的消耗，这里主要是针对flume读取大数据量excel来说的
     * @param sheetName
     * @param sheetIndex
     * @param curRow
     * @param cellList
     */
    public static Entity sendRows(String filePath, String sheetName,
                             int sheetIndex, int curRow, List<String> cellList) {
        Entity entity = new Entity();
        List<String> result = new ArrayList<>();
        if (cellList != null) {
            String one = cellList.get(0);
            //有可能出现空的问题
            String two = "";
            try {
                two = cellList.get(3);
            }catch (IndexOutOfBoundsException e){
                two =cellList.get(2);
//                System.out.println(cellList.toString());
            }
            if(!city.contains(two)){
                if(start.equals(one)){
                    sets.add(two);
                }else {
                    start = one;
                    if(sets.size() == 0){
                        sets.add(two);
                    }else if(sets.size() == 1){
                        excelSets.addAll(sets);
                        sets.clear();
                    }else {
                        result = MapMatch(sets);
                        excelSets.addAll(sets);
//                        System.out.println("one："+result.toString());
                        //记录次数
                        sets.clear();
                    }
                }
            }
        }
        entity.setCity(result);
        entity.setExcelString(excelSets);
        return entity;
    }

    public static Entity readExcel(String fileName) throws Exception {
        Map<String, Integer> totalMap = new HashMap<>();
        Entity entity = new Entity();
        int totalRows =0;
        if (fileName.endsWith(EXCEL03_EXTENSION)) { //处理excel2003文件
            ExcelXlsReader excelXls=new ExcelXlsReader();
            totalRows =excelXls.process(fileName);
        } else if (fileName.endsWith(EXCEL07_EXTENSION)) {//处理excel2007文件
            ExcelXlsxReader excelXlsxReader = new ExcelXlsxReader();
            entity = excelXlsxReader.process(fileName);
        } else{
            throw new Exception("文件格式错误，fileName的扩展名只能是xls或xlsx。");
        }
//        System.out.println("发送的总行数：" + totalRows);
        return entity;
    }
    public static List<String> MapMatch(Set<String> sets) {
        Map<String,Integer> stringStringMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        Object [] arrays = sets.toArray();
        int sum = sets.size();
        for(int i =0;i < sum;i++){
            for(int j = i+1;j < sum; j++){
                list.add(arrays[i].toString()+"-"+arrays[j].toString());
                list.add(arrays[j].toString()+"-"+arrays[i].toString());
            }
        }
        return list;
    }


}