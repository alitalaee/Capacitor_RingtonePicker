export interface RingtonePickerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
