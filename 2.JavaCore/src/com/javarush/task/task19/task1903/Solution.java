package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeData data = new IncomeData() {
            public String getCountryCode() {
                return "UA";
            }

            public String getCompany() {
                return "JavaRush Ltd.";
            }

            public String getContactFirstName() {
                return "Ivan";
            }

            public String getContactLastName() {
                return "Ivanov";
            }

            public int getCountryPhoneCode() {
                return 38;
            }

            public int getPhoneNumber() {
                return 501234567;
            }
        };
        IncomeDataAdapter a = new IncomeDataAdapter(data);

        System.out.println(a.getCompanyName());
        System.out.println(a.getCountryName());
        System.out.println(a.getName());
        System.out.println(a.getPhoneNumber());

    }
    public static class IncomeDataAdapter implements Customer,Contact {

        private IncomeData data;



        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
          //  data.getCompany()
                return data.getCompany();


        }

        @Override
        public String getCountryName() {
            String Country = null;
            for (Map.Entry<String, String> map : countries.entrySet()) {
                if (map.getKey().equals(data.getCountryCode())) Country = map.getValue();
            }
            return Country;
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String phoneNmber = String.format("%010d", data.getPhoneNumber());
            return "+"+ data.getCountryPhoneCode() + "(" + phoneNmber.substring(0,3) + ")" + phoneNmber.substring(3,6) + "-" + phoneNmber.substring(6,8)+ "-" + phoneNmber.substring(8,10);

        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}