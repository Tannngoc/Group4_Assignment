/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package randomprogram;

import java.math.*;
import java.security.SecureRandom;

/**
 *
 * @author ADMIN
 */
public class RandomSoThapPhan {

    private SecureRandom boTaoSo;

    public RandomSoThapPhan() {
        boTaoSo = new SecureRandom();
    }

    private double sinh0Toi1() {
        double ketQua = boTaoSo.nextDouble(2);
        while (ketQua > 1.0) {
            ketQua = boTaoSo.nextDouble(2);
        }

        return ketQua;
    }

    public BigDecimal sinh(BigDecimal soDau, BigDecimal soCuoi) {
        try {
            if (soCuoi.compareTo(soDau) < 0) {
                throw new ArithmeticException("Lỗi khoảng cách. Số cuối nhỏ hơn số đầu.");
            }
            BigDecimal khoangCach = soCuoi.subtract(soDau);
            BigDecimal khoangCachNho = new BigDecimal(sinh0Toi1());
            BigDecimal soNgauNhien = khoangCach.multiply(khoangCachNho).add(soDau).setScale(18, RoundingMode.HALF_UP);
            return soNgauNhien;
        } catch (ArithmeticException loiKhoangCach) {
            throw loiKhoangCach;
        }
    }

    public BigDecimal sinh(BigDecimal soDau, BigDecimal soCuoi, BigInteger soChuSoLamTron) {
        try {
            if (soCuoi.compareTo(soDau) < 0) {
                throw new ArithmeticException("Lỗi khoảng cách. Số cuối nhỏ hơn số đầu.");
            }
            if (soChuSoLamTron.compareTo(BigInteger.ZERO) < 0 || soChuSoLamTron.compareTo(new BigInteger("18")) > 0) {
                throw new ArithmeticException("Lỗi số lượng chữ số làm tròn. Số lượng chữ số nằm trong khoảng từ 0 đến 18.");
            }
            BigDecimal khoangCach = soCuoi.subtract(soDau);
            BigDecimal khoangCachNho = new BigDecimal(sinh0Toi1());
            BigDecimal soNgauNhien = khoangCach.multiply(khoangCachNho).add(soDau).setScale(soChuSoLamTron.intValue(), RoundingMode.HALF_UP);
            return soNgauNhien;
        } catch (Exception loi) {
            throw loi;
        }
    }
}
