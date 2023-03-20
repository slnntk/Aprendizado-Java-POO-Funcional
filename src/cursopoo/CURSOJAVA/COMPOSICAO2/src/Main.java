import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Post> postList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = sdf.parse("21/06/2018 13:05:44");
        String title = "Traveling to New Zealand";
        String content = "I'm going to visit this wonderful country!";
        int likes = 12;
        Post post1 = new Post(date, title, content, likes);
        post1.addComment("Have a nice trip");
        post1.addComment("Wow that's awesome");
        postList.add(post1);

        date = sdf.parse("28/07/2018 23:14:19");
        title = "Good night guys";
        content = "See you tomorrow";
        likes = 5;
        Post post2 = new Post(date, title, content, likes);
        post2.addComment("Good night");
        post2.addComment("May the Force be with you");
        postList.add(post2);

        date = sdf.parse("11/03/2023 11:49:00");
        title = "Eu amo a minha mulher";
        content = "ela é maluca";
        likes = 10000;
        Post post3 = new Post(date, title, content, likes);
        post3.addComment("Ei, eu não sou doida.");
        post3.addComment("Vou te matar!");
        postList.add(post3);

        for(Post p : postList){
            System.out.printf("%s%n" + //title//
                            "%d Likes - %s%n" + //likes - date//
                            "%s%n", //content//
                    p.getTitle(),p.getLikes(),p.getMoment(),p.getContent());
            System.out.println("Comments: ");
            for (Comment c : p.getCommentList()){
                System.out.println(c.getText());
            }
            System.out.println();
        }

    }
}

class Post {
    private Date moment;
    private String title;
    private String content;
    private Integer likes;
    private List<Comment> commentList = new ArrayList<>();

    public Post() {
    }

    public Post(Date moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public void addComment(String comment){
        this.commentList.add(new Comment(comment));
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public Date getMoment() {
        return moment;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getLikes() {
        return likes;
    }
}

class Comment {
    private String text;

    public Comment() {
    }

    public Comment(String comment) {
        this.text = comment;
    }

    public String getText() {
        return text;
    }
}