package app.dto;

import lombok.*;

import java.util.Collection;

/**
 * Created by Black on 12.02.2018.
 */
@Getter
@Setter
public class UserData extends AbstractData {
    private Long userId;
    private String email;
    private Integer groupId;
    private Collection<UserTagData> tagCollection;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserTagData extends AbstractData {
        private Long tagId;
        private String name;
    }
}

