package utils;

/**
 * @author 王强
 * @since 2025/1/21
 */
public class TimeTracker implements AutoCloseable {

    /**
     * 操作名称
     */
    private final String operationName;

    /**
     * 开始时间（纳秒）
     */
    private final long startTime;

    /**
     * 是否启用日志
     */
    private final boolean logEnabled;

    /**
     * 创建一个新的TimeTracker实例。
     *
     * @param operationName 要跟踪的操作名称
     */
    public TimeTracker(String operationName) {
        this(operationName, true);
    }

    /**
     * 私有构造函数，用于创建TimeTracker实例。
     *
     * @param operationName 操作名称
     * @param logEnabled    是否启用日志输出
     */
    private TimeTracker(String operationName, boolean logEnabled) {
        this.operationName = operationName;
        this.startTime = System.nanoTime();
        this.logEnabled = logEnabled;
        if (logEnabled) {
            System.out.printf("开始执行: %s%n", operationName);
        }
    }

    /**
     * 创建一个新的TimeTracker实例的静态工厂方法。
     *
     * @param operationName 要跟踪的操作名称
     * @return 新的TimeTracker实例
     */
    public static TimeTracker of(String operationName) {
        return new TimeTracker(operationName);
    }

    /**
     * 跟踪带返回值的代码块执行时间，异常会被包装为RuntimeException。
     *
     * @param operationName 操作名称
     * @param execution     要执行的代码块
     * @param <T>           返回值类型
     * @return 代码块的执行结果
     * @throws RuntimeException 如果执行过程中发生异常
     */
    public static <T> T track(String operationName, ThrowableSupplier<T> execution) {
        try {
            return trackThrows(operationName, execution);
        } catch (Exception e) {
            throw new RuntimeException("执行失败: " + operationName, e);
        }
    }

    /**
     * 跟踪带返回值的代码块执行时间，允许抛出异常
     *
     * @param operationName 操作名称
     * @param execution     要执行的代码块
     * @param <T>           返回值类型
     * @return 代码块的执行结果
     * @throws Exception 如果执行过程中发生异常
     */
    public static <T> T trackThrows(String operationName, ThrowableSupplier<T> execution) throws Exception {
        try (TimeTracker ignored = new TimeTracker(operationName, true)) {
            return execution.get();
        }
    }

    /**
     * 跟踪无返回值的代码块执行时间，异常会被包装为RuntimeException。
     *
     * @param operationName 操作名称
     * @param execution     要执行的代码块
     * @throws RuntimeException 如果执行过程中发生异常
     */
    public static void track(String operationName, ThrowableRunnable execution) {
        try {
            trackThrows(operationName, execution);
        } catch (Exception e) {
            throw new RuntimeException("执行失败: " + operationName, e);
        }
    }

    /**
     * 跟踪无返回值的代码块执行时间，允许抛出异常。
     *
     * @param operationName 操作名称
     * @param execution     要执行的代码块
     * @throws Exception 如果执行过程中发生异常
     */
    public static void trackThrows(String operationName, ThrowableRunnable execution) throws Exception {
        try (TimeTracker ignored = new TimeTracker(operationName, true)) {
            execution.run();
        }
    }

    @Override
    public void close() {

        if (logEnabled) {
            // 计算执行时间（转换为毫秒）
            long timeElapsed = (System.nanoTime() - startTime) / 1_000_000;
            System.out.printf("%s 执行完成，耗时: %d ms%n", operationName, timeElapsed);
        }

    }

    /**
     * 可抛出异常的Supplier函数式接口。
     *
     * @param <T> 返回值类型
     */
    @FunctionalInterface
    public interface ThrowableSupplier<T> {

        /**
         * 获取结果。
         *
         * @return 执行结果
         * @throws Exception 如果执行过程中发生错误
         */
        T get() throws Exception;

    }

    /**
     * 可抛出异常的Runnable函数式接口。
     */
    @FunctionalInterface
    public interface ThrowableRunnable {

        /**
         * 执行操作。
         *
         * @throws Exception 如果执行过程中发生错误
         */
        void run() throws Exception;

    }
}
