class TimeStampPojo{
    private String key;
    private String value;
    private int timestamp;

    public TimeStampPojo(String key, String value, int timestamp){
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }
        public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
class TimeMap {

   private Map<String, List<TimeStampPojo>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<TimeStampPojo> pojoList = timeMap.get(key);
        if(pojoList==null || pojoList.size()<1){
            pojoList = new ArrayList<>();
            timeMap.put(key, pojoList);
        }
        TimeStampPojo pojo = new TimeStampPojo(key, value, timestamp);
        pojoList.add(pojo);
    }
    
    public String get(String key, int timestamp) {
        List<TimeStampPojo> pojoList = timeMap.get(key);
        if(pojoList !=null && pojoList.size()>0){
            String result = "";
        for(TimeStampPojo pojo : pojoList){
            if(pojo.getTimestamp()<=(timestamp)){
                result = pojo.getValue();
            }else{
                break;
            }
        }
        return result;
        }
        return "";
    }
}
