//package com.javarush.task.task19.task1903;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Solutoin1 {
//    private static Map<String, String> countries = new HashMap<>();
//
//    static {
//        countries.put("UA", "Ukraine");
//        countries.put("RU", "Russia");
//        countries.put("CA", "Canada");
//    }
//
//    public static void main(String[] args) {
//
//        IncomeData data = new IncomeData() {
//            @Override
//            public String getCountryCode() {
//                return "UA";
//            }
//
//            @Override
//            public String getCompany() {
//                return "JavaRush Ltd.";
//            }
//
//            @Override
//            public String getContactFirstName() {
//                return "Ivan";
//            }
//
//            @Override
//            public String getContactLastName() {
//                return "Ivanov";
//            }
//
//            @Override
//            public int getCountryPhoneCode() {
//                return 38;
//            }
//
//            @Override
//            public int getPhoneNumber() {
//                return 501234567;
//            }
//        };
//
//        Customer customer = new IncomeDataAdapter(data);
//        Contact contact = new IncomeDataAdapter(data);
//
//        System.out.println(customer.getCompanyName());
//        System.out.println(customer.getCountryName());
//        System.out.println(contact.getName());
//        System.out.println(contact.getPhoneNumber());
//
//    }
//
//    public static class IncomeDataAdapter implements Customer, Contact {
//        private IncomeData data;
//
//        public IncomeDataAdapter(IncomeData data) {
//            this.data = data;
//        }
//
//        @Override
//        public String getCompanyName() {
//            return data.getCompany();
//        }
//
//        @Override
//        public String getCountryName() {
//            return countries.get(data.getCountryCode());
//        }
//
//        @Override
//        public String getName() {
//            return data.getContactFirstName() + " " + data.getContactLastName();
//        }
//
//        @Override
//        public String getPhoneNumber() {
//            return data.getCountryCode() + " " + data.getCountryPhoneCode();
//        }
//    }
//
//
//    public interface IncomeData {
//        String getCountryCode();        //example UA
//
//        String getCompany();            //example JavaRush Ltd.
//
//        String getContactFirstName();   //example Ivan
//
//        String getContactLastName();    //example Ivanov
//
//        int getCountryPhoneCode();      //example 38
//
//        int getPhoneNumber();           //example 501234567
//    }
//
//    public static interface Customer {
//        String getCompanyName();        //example JavaRush Ltd.
//
//        String getCountryName();        //example Ukraine
//    }
//
//    public static interface Contact {
//        String getName();               //example Ivanov, Ivan
//
//        String getPhoneNumber();        //example +38(050)123-45-67
//    }
//}
