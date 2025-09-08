import { WebPlugin } from '@capacitor/core';
import type { RingtonePickerPlugin } from './definitions';
export declare class RingtonePickerWeb extends WebPlugin implements RingtonePickerPlugin {
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
