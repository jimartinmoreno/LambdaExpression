package com.modernjava.funcprogramming.realexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BankTransfer {

    static AccountFactory accountFactory = BankAccount::new;
    static BankAccount studentBankAccount = accountFactory.getBankAccount(1, 50000, "StudentA");
    static BankAccount universityBankAccount = accountFactory.getBankAccount(2, 100000, "University");

    static BiPredicate<Double, Double> checkBalance = (balance, amount) -> balance > amount;
    static BiConsumer<String, Double> printer = (x, y) -> System.out.println(x + y);
    static BiConsumer<BankAccount, BankAccount> printer2 = (student, university) ->
            System.out.println("Ending balance of student account: " + student.getBalance() +
                    " University account: " + university.getBalance());


    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " says :: Executing Transfer");
            try {
                double amount = 1000;
                if (!checkBalance.test(studentBankAccount.getBalance(), amount)) {
                    printer.accept(Thread.currentThread().getName() + "says :: balance insufficient, ", amount);
                    return;
                }
                while (!studentBankAccount.transfer(universityBankAccount, amount)) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    //continue;
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            printer.accept(Thread.currentThread().getName() + " says transfer is successful: Balance in account ",
                    universityBankAccount.getBalance());
        });

        ExecutorService serviceThreadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            serviceThreadPool.submit(t1);
        }
        serviceThreadPool.shutdown();

        try {
            while (!serviceThreadPool.awaitTermination(24L, TimeUnit.HOURS)) {
                System.out.println("Not Yet. Still waiting for termination");
            }
        } catch (InterruptedException iee) {
            iee.printStackTrace();
        }
        printer2.accept(studentBankAccount, universityBankAccount);
    }
}

