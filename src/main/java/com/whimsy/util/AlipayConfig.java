package com.whimsy.util;

public class AlipayConfig {
	//合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
    public static String partner = "2088721396633763";

    //商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
    public static String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCP0AlTEwSpFg5zgsRa/jn/ZTV14+3otfc49nTIKWSHYYXDCa92AJp1pnzJWvo4YHdk/LWQKryjOelosAcE2ddX4lj9AgrXzd6XQqfmFAlqbOBuOcReujIAQinEkBrPuExhG0NOFO7VH7Zr2gyM8Sp440jixsgSqsfuRKDtW5OeSMKREMeH9Wsfac1kqmc4EA+YWS9Q9nHDEL6BWIVSuEV15EnFNKFKIca+HIB2aL4X/0sU+TKkoiZsWm5MWp+DPvNhO0vsQcsHa6hPtqfCv6Z3u0Y4aeekC/hgX7HKj1ONwG0JF7g3M6bxaNyXqJ8ygiw4JJcN/iZm7bblUs9tYZrvAgMBAAECggEAPVo8UCOh7lzJh3/3MvaYWZuc5hF6MrhGoxeJlMcL6zGwthdQsp/pRV3kiKZ2b0zAQuYIs1t4JI6VRCMsq2YgF48p9a5EX/KlDpTSOja8GZofWQbt/peiszeGyCPOPGXct+TAnvQRO/0Ofw6EIjDUtMQKGS1Ct6wCJWVD3l8eJ/0ww/k4GlAWqW5eG9gjwZXzVH90An1Xq5muts/tBhkMKB25jnsjuZXodOReYZVXQrkfW+SoZwRvhm2CHv4vPisHWkxMS6mpmvOBil07vg/ia05dMFmkcVjPe4toIZiXIxc9MVa8snrHC4YgyFiSIkhJtDdLBZ6OvS55mqbApOX58QKBgQDBVGyKiWFEmKQDy7JYd2JQ/40vRQgfpbKa/T6NMhiXVt55/sXKi0uOiU40WSBVWbDYul1BNEo/w2TKm3qxd4Lyz3W0jLcrCJlCPvz92VEWAJ26GMU+Q95RnrJyqIObtG8mLsaDD1kQ443sRx0K0pVm4BlSYp/8M7ZXVTEWWtsEmQKBgQC+bmfvNQUl74nPG5AAFjp1cYALWJDObgpUHOnkJfO5InnHWXeQGSX9EVq5dXzZN+XrA9p38oT7Q0m+bDDXdEArCtbTvaZkuv3CHUyCyyfRkIkCiPghzIpXgX4KNbKaSUbfZmihCGXSFsfvydNspaMGxR0MKrnl7u+iy9rSwkZIxwKBgAozbC67JPi7nRveKaDlW7iuY0K1P8J7ubrX1e8ZT5bcrIx/VuxjAS+aKxg0A7K9Msmcu8LvAWPv6WePYJ/wkGZDcBCAxEFvCLcoH609RDwG+EuTdwTcC+T+nKfUIG2czaiUG0FbE/YCK8Dl17B0gBGXjX59Wbey+tIM2rQ1Qw0xAoGABaYQvy+7b1yjodkXdGk0YrdzLOL7qKPq+oPBDFtz11IGertUqJmWXuNc5ZNumKLn1wjOOjCfcTSVw2hCKqHwJVa0+KLvhJ1nWZK06kxMahL3fXPCqH4AvIfCzVq6aYky6P2IrP4qxwiV9a7u7pIbO+As9GdwDDoCMboKS6Ynn5ECgYEAmKRmwZL410z3vpZj9D3Br84iMghs7X154HoZS32unk/9zXAKklNRJ+gjIxAfkn+f2AB8En9KU2IuAfksKSpsggODUyBSCDsCyGuLIQ+6hpXh8yMVnGDL5gxH0Ic0AoTLDJhVNZmfcfDRCHj2SD9LNQUavQCf1mSo1oQI1OLIQAU=";

    //支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
    public static String alipay_public_key  = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwiRbfvEoSw8/up7zkz708mnvpI1yoz/CusUBjsDwlTOtBKkhuSa9bWviN5CyYWbNaEWw6MHXS5zUN0kuxSx50nZOy67/WqHmCqEs6MNjbH/1NRraP1i0VzMHVfMu632kIR7jtKrQfgDLdTtnL0mIZjb0yeVWPC1wKdX9aHhGSLeu+hMTWNz3vskc2BKHUJI0E6LMs6MzZ08db0ORsl+ZEJRj2DA1X6xj1QumqO0XRK0+/h9UcUmkezpMRBuY3tRFfp3BILcBxD3fmYCIBuTv2ZmOQmC2dZTutOLNOgpvjIhMCo1+/ADQaLoInwjgwJHO4n+DZJF+et6dHAbWMpVARwIDAQAB";

    // 签名方式
    public static String sign_type = "RSA2";

    // 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
    public static String log_path ="C://";

    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String input_charset = "utf-8";

    // 接收通知的接口名
    public static String service = "/zhifubao/callbacks";
    //public static String service = "mobile.securitypay.pay";

    //APPID
    public static String app_id="2017062907595873";
}
