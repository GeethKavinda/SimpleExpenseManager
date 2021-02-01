package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {
    private final static String dbName = "180322M";
    private final static int dbVersion = 1;

    public final static String accountTable = "account_table";
    public final static String transactionTable = "transaction_table";

    public final static String accountAccountNo = "account_no";
    public final static String accountBankName = "bank_name";
    public final static String accountHolderName = "holder_name";
    public final static String accountAccountBalance = "balance";

    public final static String transactionID = "id";
    public final static String transactionAccountNo = "account_no";
    public final static String transactionType = "type";
    public final static String transactionDate = "date";
    public final static String transactionAmount = "amount";

    public final static String typeExpense = "EXPENSE";
    public final static String typeIncome = "INCOME";

    public static String getDbName() {
        return dbName;
    }

    public static int getDbVersion() {
        return dbVersion;
    }

    public static String getAccountTable() {
        return accountTable;
    }

    public static String getTransactionTable() {
        return transactionTable;
    }

    public static String getAccountAccountNo() {
        return accountAccountNo;
    }

    public static String getAccountBankName() {
        return accountBankName;
    }

    public static String getAccountHolderName() {
        return accountHolderName;
    }

    public static String getAccountAccountBalance() {
        return accountAccountBalance;
    }

    public static String getTransactionID() {
        return transactionID;
    }

    public static String getTransactionAccountNo() {
        return transactionAccountNo;
    }

    public static String getTransactionType() {
        return transactionType;
    }

    public static String getTransactionDate() {
        return transactionDate;
    }

    public static String getTransactionAmount() {
        return transactionAmount;
    }

    public static String getTypeExpense() {
        return typeExpense;
    }

    public static String getTypeIncome() {
        return typeIncome;
    }

    public DbHandler(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS " + accountTable + "(" +
                        accountAccountNo + " TEXT PRIMARY KEY," +
                        accountBankName + " TEXT NOT NULL," +
                        accountHolderName + " TEXT NOT NULL," +
                        accountAccountBalance + " REAL" +
                        ");"
        );


        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS " + transactionTable + "(" +
                        transactionID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        transactionDate + " TEXT NOT NULL," +
                        transactionAccountNo + " TEXT NOT NULL," +
                        transactionType + " TEXT NOT NULL," +
                        transactionAmount + " REAL NOT NULL," +
                        "FOREIGN KEY (" + transactionAccountNo + ") REFERENCES "
                        + accountTable + "(" + accountAccountNo + ")," +
                        "CHECK ("+transactionType+"==\""+typeExpense+"\" OR "+transactionType+"==\""+typeIncome+"\")"+
                        ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + accountTable);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + transactionTable);
        onCreate(sqLiteDatabase);
    }
}
