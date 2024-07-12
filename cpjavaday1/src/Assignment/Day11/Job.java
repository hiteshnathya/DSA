package Assignment.Day11;

public class Job implements  Comparable<Job> {
    char id;
    int deadline;

    @Override
    public int compareTo(Job o) {
        return o.profit-this.deadline ;
    }

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    int profit;


}
