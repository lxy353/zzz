public class StringBuilder {
   

	public static void main(String[] args) {
        /**StringBuilder*/
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < 7; i++) {
        	char temp=(char) ('a' + i);
            sb.append(temp);//追加单个字符
        }
        System.out.println(sb.toString());//转换成String输出
        sb.append(", I can sing my abc!");//追加字符串
        System.out.println(sb.toString());
        /**StringBuffer*/
        StringBuffer sb2 = new StringBuffer("中华人民共和国");
        sb2.insert(0, "爱").insert(0, "我");//add
        System.out.println(sb2);
        sb2.delete(0, 2);//delete
        System.out.println(sb2);
        sb2.deleteCharAt(0).deleteCharAt(0);//删除某个字符
        System.out.println(sb2.charAt(0));//获取某个字符
        System.out.println(sb2.reverse());//字符串逆序
    }

	

	
}