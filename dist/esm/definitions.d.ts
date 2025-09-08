export interface RingtonePickerPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    pickRingtone(): Promise<{
        uri: string;
        title: string;
    }>;
}
