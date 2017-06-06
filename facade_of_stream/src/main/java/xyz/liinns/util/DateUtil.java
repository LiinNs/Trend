package xyz.liinns.util;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Description:
 * Created by LiinNs on 2017-6-6 0006.
 */
@Slf4j
public class DateUtil {

    /**
     * 计算两个日期的差值 可以指定天数 月数 年数 等
     * @param dateOne
     * @param dateTwo
     * @param chronoUnit
     * @see ChronoUnit
     * @return 指定单位差值的绝对值
     * @apiNote http://www.jianshu.com/p/2949db9c3df5
     * @author LiinNs
     */
    public static long calcCountOfTwoDate(Date dateOne, Date dateTwo, ChronoUnit chronoUnit) {
        LocalDateTime localDateOne = ZonedDateTime.ofInstant(dateOne.toInstant(), ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime localDateTwo = ZonedDateTime.ofInstant(dateTwo.toInstant(), ZoneId.systemDefault()).toLocalDateTime();
        long counts;
        counts = localDateTwo.until(localDateOne, chronoUnit);
        if (log.isDebugEnabled()) {
            log.debug("\n日期{}和日期{}的{}差为{}",localDateOne, localDateTwo, chronoUnit, Math.abs(counts));
        }
        return counts;
    }

}
