package com.yz.sophia.bsf.core.util.misc;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class NumberUtil {

  private static final String PATTERN = ",###,###.00";

  private NumberUtil() {
  }

  public static boolean isNumeric(String target) {
    return StringUtils.isNumeric(target);
  }

  public static boolean isNotNumeric(String target) {
    return !StringUtils.isNumeric(target);
  }

  public static boolean isDouble(String target) {
    String[] splits = target.split("\\.");
    String digit = splits.length > 1 ? splits[1] : "";

    for (char c : digit.toCharArray()) {
      if (c > 48 && c < 58) {
        return true;
      }
    }

    return false;
  }


  public static String format(String target) {
    if (!NumberUtils.isCreatable(target)) {
      return "";
    } else {
      DecimalFormat df = new DecimalFormat("0.00");
      df.setRoundingMode(RoundingMode.HALF_UP);
      Double value = Double.parseDouble(target);
      return df.format(value);
    }
  }

  public static String format(Double target) {
    if (target == null) {
      return "";
    } else {
      DecimalFormat df = new DecimalFormat("0.00");
      df.setRoundingMode(RoundingMode.HALF_UP);
      return df.format(target);
    }
  }

  public static String formatThousands(BigDecimal target) {
    if ((new BigDecimal("0.00")).equals(target)) {
      return "0.00";
    } else {
      DecimalFormat df = new DecimalFormat(PATTERN);
      return df.format(target);
    }
  }

  public static String formatThousands(String target) {
    DecimalFormat df = new DecimalFormat(PATTERN);
    if (!"0.00".equals(target) && !"0".equals(target)) {
      return StringUtils.isNotBlank(target) ? df.format(new BigDecimal(target)) : null;
    } else {
      return "0.00";
    }
  }
}
