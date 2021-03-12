package com.pankaj.mobiustest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel implements Parcelable {

    @Expose
    @SerializedName("bonus_booster")
    private String bonus_booster;
    @Expose
    @SerializedName("campaign")
    private String campaign;
    @Expose
    @SerializedName("_cls")
    private String _cls;
    @Expose
    @SerializedName("days_since_last_purchase_min")
    private int days_since_last_purchase_min;
    @Expose
    @SerializedName("visibility_user_segments")
    private List<String> visibility_user_segments;
    @Expose
    @SerializedName("visibility_user_levels")
    private List<Integer> visibility_user_levels;
    @Expose
    @SerializedName("eligibility_user_segments")
    private List<String> eligibility_user_segments;
    @Expose
    @SerializedName("eligibility_user_levels")
    private List<Integer> eligibility_user_levels;
    @Expose
    @SerializedName("user_segmentation_type")
    private String user_segmentation_type;
    @Expose
    @SerializedName("slabs")
    private List<Slabs> slabs;
    @Expose
    @SerializedName("wager_to_release_ratio_denominator")
    private int wager_to_release_ratio_denominator;
    @Expose
    @SerializedName("wager_to_release_ratio_numerator")
    private int wager_to_release_ratio_numerator;
    @Expose
    @SerializedName("wager_bonus_expiry")
    private int wager_bonus_expiry;
    @Expose
    @SerializedName("is_bonus_booster_enabled")
    private boolean is_bonus_booster_enabled;
    @Expose
    @SerializedName("ribbon_msg")
    private String ribbon_msg;
    @Expose
    @SerializedName("tab_type")
    private String tab_type;
    @Expose
    @SerializedName("user_limit")
    private int user_limit;
    @Expose
    @SerializedName("user_redeem_limit")
    private int user_redeem_limit;
    @Expose
    @SerializedName("bonus_image_back")
    private String bonus_image_back;
    @Expose
    @SerializedName("bonus_image_front")
    private String bonus_image_front;
    @Expose
    @SerializedName("code")
    private String code;
    @Expose
    @SerializedName("last_updated_at")
    private String last_updated_at;
    @Expose
    @SerializedName("created_at")
    private String created_at;
    @Expose
    @SerializedName("tags")
    private Tags tags;
    @Expose
    @SerializedName("is_deleted")
    private boolean is_deleted;
    @Expose
    @SerializedName("is_active")
    private boolean is_active;
    @Expose
    @SerializedName("valid_until")
    private String valid_until;
    @Expose
    @SerializedName("valid_from")
    private String valid_from;
    @Expose
    @SerializedName("id")
    private String id;

    protected DataModel(Parcel in) {
        bonus_booster = in.readString();
        campaign = in.readString();
        _cls = in.readString();
        days_since_last_purchase_min = in.readInt();
        visibility_user_segments = in.createStringArrayList();
        eligibility_user_segments = in.createStringArrayList();
        user_segmentation_type = in.readString();
        wager_to_release_ratio_denominator = in.readInt();
        wager_to_release_ratio_numerator = in.readInt();
        wager_bonus_expiry = in.readInt();
        is_bonus_booster_enabled = in.readByte() != 0;
        ribbon_msg = in.readString();
        tab_type = in.readString();
        user_limit = in.readInt();
        user_redeem_limit = in.readInt();
        bonus_image_back = in.readString();
        bonus_image_front = in.readString();
        code = in.readString();
        last_updated_at = in.readString();
        created_at = in.readString();
        is_deleted = in.readByte() != 0;
        is_active = in.readByte() != 0;
        valid_until = in.readString();
        valid_from = in.readString();
        id = in.readString();
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    public String getBonus_booster() {
        return bonus_booster;
    }

    public void setBonus_booster(String bonus_booster) {
        this.bonus_booster = bonus_booster;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String get_cls() {
        return _cls;
    }

    public void set_cls(String _cls) {
        this._cls = _cls;
    }

    public int getDays_since_last_purchase_min() {
        return days_since_last_purchase_min;
    }

    public void setDays_since_last_purchase_min(int days_since_last_purchase_min) {
        this.days_since_last_purchase_min = days_since_last_purchase_min;
    }

    public List<String> getVisibility_user_segments() {
        return visibility_user_segments;
    }

    public void setVisibility_user_segments(List<String> visibility_user_segments) {
        this.visibility_user_segments = visibility_user_segments;
    }

    public List<Integer> getVisibility_user_levels() {
        return visibility_user_levels;
    }

    public void setVisibility_user_levels(List<Integer> visibility_user_levels) {
        this.visibility_user_levels = visibility_user_levels;
    }

    public List<String> getEligibility_user_segments() {
        return eligibility_user_segments;
    }

    public void setEligibility_user_segments(List<String> eligibility_user_segments) {
        this.eligibility_user_segments = eligibility_user_segments;
    }

    public List<Integer> getEligibility_user_levels() {
        return eligibility_user_levels;
    }

    public void setEligibility_user_levels(List<Integer> eligibility_user_levels) {
        this.eligibility_user_levels = eligibility_user_levels;
    }

    public String getUser_segmentation_type() {
        return user_segmentation_type;
    }

    public void setUser_segmentation_type(String user_segmentation_type) {
        this.user_segmentation_type = user_segmentation_type;
    }

    public List<Slabs> getSlabs() {
        return slabs;
    }

    public void setSlabs(List<Slabs> slabs) {
        this.slabs = slabs;
    }

    public int getWager_to_release_ratio_denominator() {
        return wager_to_release_ratio_denominator;
    }

    public void setWager_to_release_ratio_denominator(int wager_to_release_ratio_denominator) {
        this.wager_to_release_ratio_denominator = wager_to_release_ratio_denominator;
    }

    public int getWager_to_release_ratio_numerator() {
        return wager_to_release_ratio_numerator;
    }

    public void setWager_to_release_ratio_numerator(int wager_to_release_ratio_numerator) {
        this.wager_to_release_ratio_numerator = wager_to_release_ratio_numerator;
    }

    public int getWager_bonus_expiry() {
        return wager_bonus_expiry;
    }

    public void setWager_bonus_expiry(int wager_bonus_expiry) {
        this.wager_bonus_expiry = wager_bonus_expiry;
    }

    public boolean getIs_bonus_booster_enabled() {
        return is_bonus_booster_enabled;
    }

    public void setIs_bonus_booster_enabled(boolean is_bonus_booster_enabled) {
        this.is_bonus_booster_enabled = is_bonus_booster_enabled;
    }

    public String getRibbon_msg() {
        return ribbon_msg;
    }

    public void setRibbon_msg(String ribbon_msg) {
        this.ribbon_msg = ribbon_msg;
    }

    public String getTab_type() {
        return tab_type;
    }

    public void setTab_type(String tab_type) {
        this.tab_type = tab_type;
    }

    public int getUser_limit() {
        return user_limit;
    }

    public void setUser_limit(int user_limit) {
        this.user_limit = user_limit;
    }

    public int getUser_redeem_limit() {
        return user_redeem_limit;
    }

    public void setUser_redeem_limit(int user_redeem_limit) {
        this.user_redeem_limit = user_redeem_limit;
    }

    public String getBonus_image_back() {
        return bonus_image_back;
    }

    public void setBonus_image_back(String bonus_image_back) {
        this.bonus_image_back = bonus_image_back;
    }

    public String getBonus_image_front() {
        return bonus_image_front;
    }

    public void setBonus_image_front(String bonus_image_front) {
        this.bonus_image_front = bonus_image_front;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLast_updated_at() {
        return last_updated_at;
    }

    public void setLast_updated_at(String last_updated_at) {
        this.last_updated_at = last_updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getValid_until() {
        return valid_until;
    }

    public void setValid_until(String valid_until) {
        this.valid_until = valid_until;
    }

    public String getValid_from() {
        return valid_from;
    }

    public void setValid_from(String valid_from) {
        this.valid_from = valid_from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bonus_booster);
        dest.writeString(campaign);
        dest.writeString(_cls);
        dest.writeInt(days_since_last_purchase_min);
        dest.writeStringList(visibility_user_segments);
        dest.writeStringList(eligibility_user_segments);
        dest.writeString(user_segmentation_type);
        dest.writeInt(wager_to_release_ratio_denominator);
        dest.writeInt(wager_to_release_ratio_numerator);
        dest.writeInt(wager_bonus_expiry);
        dest.writeByte((byte) (is_bonus_booster_enabled ? 1 : 0));
        dest.writeString(ribbon_msg);
        dest.writeString(tab_type);
        dest.writeInt(user_limit);
        dest.writeInt(user_redeem_limit);
        dest.writeString(bonus_image_back);
        dest.writeString(bonus_image_front);
        dest.writeString(code);
        dest.writeString(last_updated_at);
        dest.writeString(created_at);
        dest.writeByte((byte) (is_deleted ? 1 : 0));
        dest.writeByte((byte) (is_active ? 1 : 0));
        dest.writeString(valid_until);
        dest.writeString(valid_from);
        dest.writeString(id);
    }

    public static class Slabs {
        @Expose
        @SerializedName("otc_max")
        private int otc_max;
        @Expose
        @SerializedName("otc_percent")
        private int otc_percent;
        @Expose
        @SerializedName("wagered_max")
        private int wagered_max;
        @Expose
        @SerializedName("wagered_percent")
        private int wagered_percent;
        @Expose
        @SerializedName("max")
        private int max;
        @Expose
        @SerializedName("min")
        private int min;
        @Expose
        @SerializedName("num")
        private int num;
        @Expose
        @SerializedName("name")
        private String name;

        public int getOtc_max() {
            return otc_max;
        }

        public void setOtc_max(int otc_max) {
            this.otc_max = otc_max;
        }

        public int getOtc_percent() {
            return otc_percent;
        }

        public void setOtc_percent(int otc_percent) {
            this.otc_percent = otc_percent;
        }

        public int getWagered_max() {
            return wagered_max;
        }

        public void setWagered_max(int wagered_max) {
            this.wagered_max = wagered_max;
        }

        public int getWagered_percent() {
            return wagered_percent;
        }

        public void setWagered_percent(int wagered_percent) {
            this.wagered_percent = wagered_percent;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Tags {
    }

}
