package startup;

import com.google.gson.Gson;

/**
 * ToDo: Describe class here
 *
 * @author Michael Barfs <michael.barfs@gmail.com>
 * @version 27.04.2016
 */
public class Wochenplan {
    private String content;
    private long id;

    private static Gson gson = new Gson();

    public Wochenplan(long id, String content){
        this.id = id;
        this.content = content;
    }

    private boolean correctJson(){
        return content != null && !content.isEmpty();
    }

    public static Wochenplan fromJson(String json) throws  IllegalArgumentException
    {
        Wochenplan plan = gson.fromJson(json, Wochenplan.class);
        if(plan == null){
            throw new IllegalArgumentException("Body is empty");
        }
        if(!plan.correctJson())
        {
            throw new IllegalArgumentException("Not all required variables are defined in the json!");
        }
        return plan;
    }

    public long getId() {return id;}
    public void setID(long id) {this.id = id;}
    public String getContent() { return content;}
    public String toJson() {return gson.toJson(this);}
}
