package cn.com.taurus.common.utils;

/**
 * @author tby
 * @description
 * @date 2022-08-22 15:14
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object)
    {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object)
    {
        return !isNull(object);
    }

}
