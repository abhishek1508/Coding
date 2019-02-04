import java.util.ArrayList;
import java.util.List;

public class LC_811_SubdomainVisitCount {

    public static void main(String[] args) {
        String[] arr = new String[]{"9001 discuss.leetcode.com"};
        subdomainVisits(arr);
    }


    public static List<String> subdomainVisits(String[] cpdomains) {
        for (int i = 0; i < cpdomains.length; i++) {
            String[] domainCount = cpdomains[i].split("\\s+");
            int count = Integer.parseInt(domainCount[0]);
            System.out.println(count);
            String domain = domainCount[1];
            domains(domain);
        }
        return null;
    }

    private static List<String> domains(String domain) {
        List<String> domainList = new ArrayList<>();
        String temp = domain;
        while (temp.contains(".")) {
            domainList.add(temp);
            int index = temp.indexOf(".");
            temp = temp.substring(index+1, temp.length());
            System.out.println(temp);
        }
        domainList.add(temp);
        return domainList;
    }
}
