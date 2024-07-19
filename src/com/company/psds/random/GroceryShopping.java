package com.company.psds.random;

public class GroceryShopping {
    public static void main(String[] args) {
        String[] strings = {"orange","-2","20","apple","1","10"};
        System.out.println(getTotal(strings));
    }

    static String getTotal(String[] groceryList){

        StringBuilder stringBuilder = new StringBuilder();
        int grandTotal = 0;

        for (int i=1; i<groceryList.length-1; i+=3){
            try {
                int total = Integer.parseInt(groceryList[i]) * Integer.parseInt(groceryList[i+1]);
                if (total > 0) {
                    stringBuilder.append(total).append("+");
                    grandTotal += total;
                }
            } catch (Exception ignored){

            }
        }
        int indx = stringBuilder.length();
        stringBuilder.delete(indx-1,indx);
        return stringBuilder.append("=").append(grandTotal).toString();
    }
}
