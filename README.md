# NaturalGrowth

A Minecraft plugin that automatically plants dropped items instead of letting them despawn.

## Features

- Automatically plants dropped saplings, flowers, crops, fungi, and mushrooms
- Supports all types of saplings including large trees
- Special handling for 2x2 tree placement
- Crop planting support with farmland requirements
- Configurable through commands and config file

## Commands

- `/doPlaceDespawn [true/false]` - Enable/disable general item planting
- `/doPlaceCrops [true/false]` - Enable/disable crop planting
- `/do2x2Placement [true/false]` - Enable/disable 2x2 tree placement
- `/toggletowngrowth [true/false]` - Toggle natural growth in your town

## Permissions

- `plugin.Rules` - Allows players to change config settings (default: op)

## Building

This project uses Maven for building. To build the plugin:

```bash
mvn clean package
```

The compiled plugin will be in the `target` directory as `NaturalGrowth-1.4.jar`

## Installation

1. Download the latest release from the releases page
2. Place the jar file in your server's `plugins` directory
3. Restart your server or use a plugin manager to load the plugin

## Configuration

The plugin creates a config.yml file with the following default settings:

- `doPlaceDespawn`: true
- `doPlaceCrops`: true
- `do2x2Placement`: true

## Requirements

- Minecraft 1.21.4
- Spigot/Paper server
- Java 8 or higher
- Towny

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

ThePhilosophiCat #edited by logichh from conquerearthmc.com

https://legacy.curseforge.com/minecraft/bukkit-plugins/naturalgrowth

https://youtu.be/9b7CvWcjuFw

Made by CrazyMonkeyYT

Towny Addon by [ConquerEarthMC](https://www.conquerearthmc.com/)
