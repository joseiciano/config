import java.util.*;
import java.io.*;

class Transaction implements Comparable<Transaction> {
  private String name; // Transaction name
  private String buyOrSell; // Was the transaction buying or selling
  private String stockOrBond; // Is the transaction stock or bond related
  private Double amount; // How much was the transaction

  public Transaction(String n, String b, String s, Double a) {
    name = n;
    buyOrSell = b;
    stockOrBond = s;
    amount = a;
  }

  public String getName() {
    return name;
  }

  public String getBuyOrSell() {
    return buyOrSell;
  }

  public String getStockOrBond() {
    return stockOrBond;
  }

  public Double getAmount() {
    return amount;
  }

  public int compareTo(Transaction t) {
    if (!name.equals(t.getName()))
      return name.compareTo(t.getName());
    else
      return stockOrBond.compareTo(t.getStockOrBond());
  }

  public String toString() {
    return getBuyOrSell() + ", " + getName() + ", " + getAmount();
  }
}

class AssetInfo {
  private Map<String, Double> stocks;
  private Map<String, Double> bonds;
  private Set<String> entries;

  public AssetInfo(String[] info) {
    stocks = new HashMap<>();
    bonds = new HashMap<>();
    entries = new HashSet<>();

    for (String asset : info) {
      add(asset);
    }
  }

  public Double getStock(String stockName) {
    return stocks.get(stockName);
  }

  public Double getBond(String bondName) {
    return bonds.get(bondName);
  }

  // Adds a new asset to the stocks/bonds hashmaps
  private void add(String asset) {
    String[] assetSplit = asset.split(",");
    String name = assetSplit[0];
    String type = assetSplit[1];
    Double amount = Double.parseDouble(assetSplit[2]);

    if (type.equals("STOCK"))
      stocks.put(name, amount);
    else
      bonds.put(name, amount);

    entries.add(name);
  }

  // Returns the union of entries in this AssetInfo and another
  public TreeSet<String> union(AssetInfo assets) {
    TreeSet<String> unionedSet = new TreeSet<>();

    unionedSet.addAll(entries);
    unionedSet.addAll(assets.entries);

    return unionedSet;
  }
}

public class test {

  static void go(String input) {
    String[] holdings = input.split(":");
    String[] portfolioInfo = holdings[0].split("\\|");
    String[] benchmarkInfo = holdings[1].split("\\|");

    AssetInfo portfolio = new AssetInfo(portfolioInfo);
    AssetInfo benchmark = new AssetInfo(benchmarkInfo);

    List<Transaction> transactions = new ArrayList<>();

    for (String assetName : portfolio.union(benchmark)) {
      Double pStock = portfolio.getStock(assetName);
      Double pBond = portfolio.getBond(assetName);

      Double bStock = benchmark.getStock(assetName);
      Double bBond = benchmark.getBond(assetName);

      if (pStock == null || bStock == null) {
        if (pStock == null && bStock != null)
          transactions.add(new Transaction(assetName, "BUY", "STOCK", bStock));
        else if (bStock == null && pStock != null)
          transactions.add(new Transaction(assetName, "SELL", "STOCK", pStock));
      } else {
        if (pStock < bStock)
          transactions.add(new Transaction(assetName, "BUY", "STOCK", bStock - pStock));
        else if (pStock > bStock)
          transactions.add(new Transaction(assetName, "SELL", "STOCK", pStock - bStock));
      }

      if (pBond == null || bBond == null) {
        if (pBond == null && bBond != null)
          transactions.add(new Transaction(assetName, "BUY", "BOND", bBond));
        else if (bBond == null && pBond != null)
          transactions.add(new Transaction(assetName, "SELL", "BOND", pBond));
      } else {
        if (pBond < bBond)
          transactions.add(new Transaction(assetName, "BUY", "BOND", bBond - pBond));
        else if (pBond > bBond)
          transactions.add(new Transaction(assetName, "SELL", "BOND", pBond - bBond));
      }

    }

    Collections.sort(transactions);
    for (Transaction currentTransaction : transactions)
      System.out.println(currentTransaction);
  }

  public static void main(String[] args) {
    String a = "Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15";

    // (BUY/SELL), Name, Stockorbond, amount
    // name first, if names are same stocks first
    go(a);
  }
}