package com.zhongyp.transaction;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/1
 * mail: zhongyp001@163.com
 */

public class StockProcessServiceImpl implements IStockProcessService{
    private IAccountDao accountDao;
    private IStockDao stockDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setStockDao(IStockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    public void openAccount(String aname, double money) {
        accountDao.insertAccount(aname, money);
    }

    @Override
    public void openStock(String sname, int amount) {
        stockDao.insertStock(sname, amount);
    }

    @Override
    public void buyStock(String aname, double money, String sname, int amount) throws StockException {
        boolean isBuy = true;
        accountDao.updateAccount(aname, money, isBuy);
        //故意抛出异常
        if (true) {
            throw new StockException("购买股票异常");
        }
        stockDao.updateStock(sname, amount, isBuy);
    }

}
