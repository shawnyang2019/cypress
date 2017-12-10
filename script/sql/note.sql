-- 清理任务
DELETE FROM qrtz_blob_triggers;
DELETE FROM qrtz_calendars;
DELETE FROM qrtz_cron_triggers;
DELETE FROM qrtz_fired_triggers;
DELETE FROM qrtz_job_details;
DELETE FROM qrtz_locks;
DELETE FROM qrtz_paused_trigger_grps;
DELETE FROM qrtz_scheduler_state;
DELETE FROM qrtz_simple_triggers;
DELETE FROM qrtz_simprop_triggers;
DELETE FROM qrtz_triggers;
DELETE FROM schedule_job;
DELETE FROM schedule_job_log;