package com.progressquest.ultra.model;

public enum Classes {

    UR_PALADIN("Ur Palading"), //
    VOODOO_PRINCESS("Voodoo Princess"), //
    ROBOT_MONK("Robot Monk"), //
    MU_FU_MONK("Mu-Fu Monk"), //
    MAGE_ILLUSIONER("Mage Illusioner"), //
    SHIV_KNIGHT("Shiv Knight"), //
    INNER_MASON("Inner Mason"), //
    FIGHTER_ORGANIST("Fighter/Organist"), //
    PUMA_BURGULAR("Puma Burgular"), //
    RUNELOREMASTER("Runeloremaster"), //
    HUNTER_STRANGLER("Hunter Strangler"), //
    BATTLE_FELON("Battle-Felon"), //
    TICKLE_MIMIC("Tickle-Mimic"), //
    SLOW_POISONER("Slow Poisoner"), //
    BASTARD_LUNATIC("Bastard Lunatic"), //
    JUNGLE_CLOWN("Jungle Clown"), //
    BIRDRIDER("Birdrider"), //
    VERMINEER("Vermineer");

    private String name;

    private Classes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
