package com.boommanpro.springenumstrategypattern.common;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.annotation.AnnotationUtils;

/**
 * @author wangqimeng
 * @date 2020/5/4 20:47
 */
@FunctionalInterface
public interface EnumTypeFlag<E extends Enum<E>, A extends Annotation> {

    /**
     * 根据枚举注解获取Annotation
     *
     * @param annotation 注解
     * @return Enum
     */
    E getValue(A annotation);

    /**
     * BeanMap2EnumMap
     * @param beanMap applicationContext.getBeansOfType();
     * @param annotationType annotation
     * @param enumTypeFlag current interface
     * @param <E> Enum
     * @param <I> ActionInterface
     * @param <A> Annotation
     * @return
     */
    static <E extends Enum<E>, I, A extends Annotation> Map<E, I> beanMap2EnumMap(Map<String, I> beanMap, Class<A> annotationType, EnumTypeFlag<E, A> enumTypeFlag) {
        Map<E, I> result = new HashMap<>(beanMap.size());
        beanMap.forEach((s, bean) -> {
            A annotation = AnnotationUtils.findAnnotation(bean.getClass(), annotationType);
            if (annotation == null) {
                return;
            }
            E value = enumTypeFlag.getValue(annotation);
            result.put(value, bean);
        });
        return result;
    }
}
