import java.util.ArrayList;

public class SleepingBarber {


    private static int TOTAL_CHAIRS = 5;

    public SleepingBarber() {

        new Thread(() -> {
            while (true) {
                barber(new Customer());
            }
        }).start();
    }

    public ArrayList<Customer> customers = new ArrayList<Customer>();
    // This ArrayList holds results that have been
    // produced and are waiting to be consumed.

    public void barber(Customer customer) {
        synchronized (customers) {
            while (customers.size()==0){
                try {
                    customers.wait();//sleeping
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            customers.remove(0);
            System.out.println(customers.size());
        }
    }
        public void custome() {
            synchronized (customers) {
                if (customers.size()==TOTAL_CHAIRS) return;

                customers.notify();
                customers.add(new Customer());
                System.out.println(customers.size());

            }

        }

    }

