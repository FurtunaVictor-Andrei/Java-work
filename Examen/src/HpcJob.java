public class HpcJob {
    private String jobId;
    private String user;
    private String queue;
    private int nodesUsed;
    private int durationMin;
    private int cpuHours;
    private String status;

    public HpcJob() {
        this.jobId = "";
        this.user = "";
        this.queue = "";
        this.nodesUsed = 0;
        this.durationMin = 0;
        this.cpuHours = 0;
        this.status = "";
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public int getNodesUsed() {
        return nodesUsed;
    }

    public void setNodesUsed(int nodesUsed) {
        this.nodesUsed = nodesUsed;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public int getCpuHours() {
        return cpuHours;
    }

    public void setCpuHours(int cpuHours) {
        this.cpuHours = cpuHours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return jobId +" " + user + " " + queue+ " "+nodesUsed+" "+durationMin+" "+cpuHours+" "+status;
    }
}
