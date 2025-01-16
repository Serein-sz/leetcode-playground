package test;

import java.io.Serializable;

/**
 * @author 王强
 * @since 2024/12/27
 */
@FunctionalInterface
public interface IGetter <T,R> extends Serializable {
    R get(T source);
}
