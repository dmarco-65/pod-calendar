package utils;


public enum RoleEnum {
    ADMIN(1),
    GAME_MASTER(2),
    PLAYER(3),
    INACTIVE(4);

    private final int id;

    RoleEnum(int id) {
        this.id = id;
    }

    public static RoleEnum getById(int id) {
        for (RoleEnum role : values()) {
            if (role.getId() == id) {
                return role;
            }
        }
        throw new IllegalArgumentException("Aucun rôle trouvé pour l'id: " + id);
    }

    public int getId() {
        return id;
    }

    public PermissionEnum[] getPermissionsByRole(RoleEnum role) {
        return switch (role) {
            case ADMIN -> PermissionEnum.values();
            case GAME_MASTER -> new PermissionEnum[]{
                    PermissionEnum.CREATE_SONDAGE,
                    PermissionEnum.EDIT_SONDAGE,
                    PermissionEnum.VIEW_RESULT,
                    PermissionEnum.ADD_PLAYER,
                    PermissionEnum.REMOVE_PLAYER,
                    PermissionEnum.ANSWER_SONDAGE
            };
            case PLAYER -> new PermissionEnum[]{
                    PermissionEnum.VIEW_RESULT,
                    PermissionEnum.ANSWER_SONDAGE
            };
            case INACTIVE -> new PermissionEnum[]{};
        };
    }
}
