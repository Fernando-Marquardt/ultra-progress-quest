package com.progressquest.ultra.model;

public enum Races {

    HALF_ORC("Half Orc"), //
    HALF_MAN("Half Man"), //
    HALF_HALFLING("Half Halfling"), //
    DOUBLE_HOBBIT("Double Hobbit"), //
    GOBHOBBIT("Gobhobbit"), //
    LOW_ELF("Low Elf"), //
    DUNG_ELF("Dung Elf"), //
    TALKING_PONY("Talking Pony"), //
    GYROGNOME("Gyrognome"), //
    LESSER_DWARF("Lesser Dwarf"), //
    CRESTED_DWARF("Crested Dwarf"), //
    EEL_MAN("Eel Man"), //
    PANDA_MAN("Panda Man"), //
    TRANS_KOBOLD("Trans-Kobold"), //
    ENCHANTED_MOTORCYCLE("Enchanted Motorcycle"), //
    WILL_THE_WISP("Will o' the Wisp"), //
    BATTLE_FINCH("Battle-Finch"), //
    DOUBLE_WOOKIEE("Double Wookiee"), //
    SKRAELING("Skraeling"), //
    DEMICANADIAN("Demicanadian"), //
    LAND_SQUID("Land Squid");

    private String name;

    private Races(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
