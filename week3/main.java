public class main {
    public static void main(String[] args) {
        person p1 = new person("wangzehua", "001");
        student p2 = new student("cuizhao", "002");
        lecturer p3 = new lecturer("edward", "003");
        p1.introduce();
        p2.introduce();
        p3.introduce();
    }
}