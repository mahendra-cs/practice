package com.company.psds.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*

https://leetcode.com/problems/subdomain-visit-count/description/

 */
public class DomainVisit {

    public static void main(String[] args) {
        String[] cpdomains = {"9001 discuss.leetcode.com"};

        subdomainVisits(cpdomains);

        String[] cpdomains1 = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(cpdomains1);
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains){
            int hitCount = Integer.parseInt(cpdomain.split(" ")[0]);
            String subDomains = cpdomain.split(" ")[1];
            String[] fields = subDomains.split("\\.");
            int n = fields.length;
            String key = "";
            for (int i=n-1; i>=0; i--){
                if (key.isEmpty())
                    key = fields[i] + key;
                else
                    key = fields[i] +"."+key;
                int curHit = 0;
                if (map.get(key) != null) {
                    curHit = map.get(key);
                }

                map.put(key, curHit+hitCount);
            }

        }

        return map.entrySet().stream().map((x) -> x.getValue() + " " + x.getKey()).collect(Collectors.toList());
    }
}
