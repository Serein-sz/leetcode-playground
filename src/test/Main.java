package test;

import java.beans.Introspector;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 王强
 * @since 2024/11/6
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        int total = 666;
        int batchSize = 50;
        for (int i = 0; i < (total + batchSize - 1) / batchSize; i++) {
            int start = i * batchSize;
            int end = Math.min(total, (i + 1) * batchSize);
            System.out.println("start = " + start + ", end = " + end);
        }
    }

    public static <T, R> String getFieldName(IGetter<T, R> getter) {
        try {
            Method method = getter.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);
            SerializedLambda lambda = (SerializedLambda) method.invoke(getter);
            String implMethodName = lambda.getImplMethodName();
            if (implMethodName == null) {
                throw new RuntimeException("lambda method name is null");
            }
            String methodName = "";
            if (implMethodName.startsWith("is")) {
                methodName = implMethodName.substring(2);
            }
            if (implMethodName.startsWith("get")) {
                methodName = implMethodName.substring(3);
            }
            return Introspector.decapitalize(methodName);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}

class Position {

    private Integer rowIndex;

    private Integer columnIndex;

    public Position() {
    }

    public Position(Integer rowIndex, Integer columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(Integer columnIndex) {
        this.columnIndex = columnIndex;
    }
}