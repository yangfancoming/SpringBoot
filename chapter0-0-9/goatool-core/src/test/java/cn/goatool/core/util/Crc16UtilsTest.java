package cn.goatool.core.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Crc 校检测试类
 * @date 2019/12/4---15:56
 */
public class Crc16UtilsTest extends TestData {

    @Test
    public void test() {
        int crc = Crc16Utils.calcCrc16(primitiveArray);
        String crc16Str = String.format("%04x", crc);
        Assert.assertEquals("a080", crc16Str);
        String reverse = crc16Str.substring(2) + crc16Str.substring(0, 2);
        Assert.assertEquals("80a0", reverse);
    }

    @Test
    public void test1()   {
        byte[] bytes = ByteArrayUtils.convertToPrimitiveArray(objectArray);
        int crc = Crc16Utils.calcCrc16(bytes);
        String crc16Str = String.format("%04x", crc);
        Assert.assertEquals("097c", crc16Str);
        String reverse = crc16Str.substring(2) + crc16Str.substring(0, 2);
        Assert.assertEquals("7c09", reverse);
    }
}
