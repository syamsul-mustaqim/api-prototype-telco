package syam.project.CustomResponse;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Content {
    private Object content;

    public Object getContent() {
        return content;
    }
    public void setContent(Object response) {
        this.content = response;
    }

}
