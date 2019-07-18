package io.repaint.maven.tiles

import groovy.transform.CompileStatic
import org.apache.maven.model.Plugin;

@CompileStatic
final class Constants {

    public static final String TILEPLUGIN_GROUP0 = "io.repaint.maven"
    public static final String TILEPLUGIN_GROUP1 = "io.avaje.maven"
    public static final String TILEPLUGIN_ARTIFACT = "tiles-maven-plugin"
    public static final String TILE_POM = "tile.xml"

    private static final String TILEPLUGIN_KEY0 = "${TILEPLUGIN_GROUP0}:${TILEPLUGIN_ARTIFACT}"
    private static final String TILEPLUGIN_KEY1 = "${TILEPLUGIN_GROUP1}:${TILEPLUGIN_ARTIFACT}"

    private Constants() {}

    /**
     * Return true if this is a Tile plugin.
     */
    static boolean isTilePlugin(Plugin plugin) {
        return plugin.artifactId == TILEPLUGIN_ARTIFACT && (plugin.groupId == TILEPLUGIN_GROUP0 || plugin.groupId == TILEPLUGIN_GROUP1)
    }

    /**
     * Determine the plugin id (repaint or forked avaje plugin id).
     */
    static String tilePluginId(Set<String> pluginIds) {
        if (pluginIds.contains(TILEPLUGIN_KEY0)) {
            return TILEPLUGIN_KEY0;
        }
        if (pluginIds.contains(TILEPLUGIN_KEY1)) {
            return TILEPLUGIN_KEY1;
        }
        return null

    }
}
