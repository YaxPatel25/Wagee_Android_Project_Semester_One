package com.example.wagee_android_project_semester_one.placeholder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Employee_Name {
    /**
     * An array of sample (placeholder) items.
     */
    public static final List<EmployeeName> ITEMS = new ArrayList<EmployeeName>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, EmployeeName> ITEM_MAP = new HashMap<String, EmployeeName>();

    private static final int COUNT = 6;
    private static int alpha = 65;
    public static String tag = "Employee  ";

    public void getname(String tag)
    {
        this.tag = tag;
    }

    static {
        // Add some sample items.

        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceholderItem(i));
            alpha++;
        }
    }

    private static void addItem(EmployeeName item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    private static EmployeeName createPlaceholderItem(int position) {

        return new EmployeeName(String.valueOf(position),tag+" "+ Character.toString ((char) alpha), makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class EmployeeName {
        public final String id;
        public final String content;
        public final String details;
        public final Integer alphabets = 65;


        public EmployeeName(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }

    }
}