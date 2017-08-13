package org.interesting.cypress.common.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author vv
 * @since 2017/8/13.
 */
public class DateUtilTest {
    @Test
    public void today() throws Exception {
        System.out.println(DateUtil.today()); //2017-08-13
    }

    @Test
    public void yesterday() throws Exception {
        System.out.println(DateUtil.yesterday());
    }

    @Test
    public void format() {
        System.out.println(DateUtil.now(DateUtil.PTN_DATE));
        System.out.println(DateUtil.now(DateUtil.PTN_DATE_TIME));
        System.out.println(DateUtil.format(LocalDate.now(), DateUtil.PTN_DATE));

    }

    @Test
    public void day() throws Exception {
        Assert.assertEquals("2017-08-13", DateUtil.day(1502602020000L));
    }

    @Test
    public void dayTime() throws Exception {
        Assert.assertEquals("2017-08-13 13:27:00", DateUtil.dayTime(1502602020000L));
    }

    @Test
    public void parse() throws Exception {
        LocalDateTime dateTime = DateUtil.parseToDateTime("2017-08-13 13:27:00", DateUtil.PTN_DATE_TIME);
        System.out.println(dateTime.toString());
    }

}